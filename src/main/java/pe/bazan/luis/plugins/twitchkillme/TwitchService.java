package pe.bazan.luis.plugins.twitchkillme;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.pubsub.events.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pe.bazan.luis.plugins.twitchkillme.events.*;
import pe.bazan.luis.plugins.twitchkillme.tasks.TwitchRefreshToken;

import java.io.IOException;
import java.net.*;

public class TwitchService {
  private TwitchKillMe twitchKillMe;
  private OAuth2Credential credential;
  private OAuth2Credential chatCredential;
  private TwitchClient client;

  public TwitchService(TwitchKillMe plugin) {
    this.twitchKillMe = plugin;
    refreshToken();
    this.credential = new OAuth2Credential("twitch", twitchKillMe.getMainConfigManager().getTwitchToken());
    this.chatCredential = new OAuth2Credential("twitch", twitchKillMe.getMainConfigManager().getChatToken());
    this.client = buildClient();
    subscribeTopics();
    registerEvents();
    joinChannels();
  }

  public void joinChannels() {
    for (String channel : twitchKillMe.getMainConfigManager().getChannelsName()) {
      client.getChat().joinChannel(channel);
    }
  }

  public void registerEvents() {
    client.getEventManager().onEvent(HypeTrainLevelUpEvent.class, HypeTrainEvent::onHypeTrain);
    client.getEventManager().onEvent(RewardRedeemedEvent.class, ChannelPointsEvent::onRewardRedeemed);
    client.getEventManager().onEvent(ChannelBitsEvent.class, BitsEvent::onCheer);
    client.getEventManager().onEvent(ChannelSubscribeEvent.class, SubscribeEvent::onSub);
    client.getEventManager().onEvent(ChannelSubGiftEvent.class, SubscriptionsGiftEvent::onSubGift);
  }

  public void subscribeTopics() {
    for (String channel : twitchKillMe.getMainConfigManager().getChannelsId()) {
      client.getPubSub().listenForChannelPointsRedemptionEvents(credential, channel);
      client.getPubSub().listenForHypeTrainEvents(credential, channel);
      client.getPubSub().listenForCheerEvents(credential, channel);
      client.getPubSub().listenForSubscriptionEvents(credential, channel);
      client.getPubSub().listenForChannelSubGiftsEvents(credential, channel);
    }
  }

  private TwitchClient buildClient() {
    return TwitchClientBuilder.builder()
            .withDefaultAuthToken(credential)
            .withChatAccount(chatCredential)
            .withEnableChat(true)
            .withEnablePubSub(true)
            .build();
  }

  public void sendMessage(String channelId, String msg) {
    client.getChat().sendMessage(channelId, msg);
  }

  public void reload() {
    closeConnection();
    this.credential = new OAuth2Credential("twitch", twitchKillMe.getMainConfigManager().getTwitchToken());
    this.chatCredential = new OAuth2Credential("twitch", twitchKillMe.getMainConfigManager().getChatToken());
    this.client = buildClient();
    subscribeTopics();
    registerEvents();
    joinChannels();
  }

  public void refreshToken() {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpUriRequest request = RequestBuilder.post()
              .setUri(new URI("https://id.twitch.tv/oauth2/token"))
              .addHeader("Content-Type", "application/x-www-form-urlencoded")
              .addParameter("client_id", TwitchKillMe.getInstance().getMainConfigManager().getClientId())
              .addParameter("client_secret", TwitchKillMe.getInstance().getMainConfigManager().getClientSecret())
              .addParameter("grant_type", "refresh_token")
              .addParameter("refresh_token", TwitchKillMe.getInstance().getMainConfigManager().getRefreshToken())
              .build();
      CloseableHttpResponse response = httpclient.execute(request);
      try {
        String data = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(data);
        String tokenType = (String) json.get("token_type");
        if(!tokenType.equals("bearer")) {
          TwitchKillMe.reportError("Refresh Token fail!");
          return;
        }
        String newToken = (String) json.get("access_token");
        Long expires_in = (long) json.get("expires_in");
        twitchKillMe.getMainConfigManager().setToken(newToken);
        new TwitchRefreshToken(expires_in);
      } catch (ParseException e) {
        TwitchKillMe.reportError("Refresh Token exception");
      } finally {
        response.close();
      }
    } catch (URISyntaxException | IOException e) {
      TwitchKillMe.reportError("Refresh Token exception");
    }
  }

  public void closeConnection() {
    client.getPubSub().close();
    client.getChat().getChannels().forEach((channel) -> {
      client.getChat().leaveChannel(channel);
    });
    client.close();
  }
}
