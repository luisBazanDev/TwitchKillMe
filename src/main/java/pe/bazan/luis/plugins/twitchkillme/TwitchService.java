package pe.bazan.luis.plugins.twitchkillme;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.pubsub.events.ChannelBitsEvent;
import com.github.twitch4j.pubsub.events.HypeTrainLevelUpEvent;
import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;
import pe.bazan.luis.plugins.twitchkillme.events.BitsEvent;
import pe.bazan.luis.plugins.twitchkillme.events.ChannelPointsEvent;
import pe.bazan.luis.plugins.twitchkillme.events.HypeTrainEvent;

public class TwitchService {
  private TwitchKillMe twitchKillMe;
  private OAuth2Credential credential;
  private OAuth2Credential chatCredential;
  private TwitchClient client;

  public TwitchService(TwitchKillMe plugin) {
    this.twitchKillMe = plugin;
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
  }

  public void subscribeTopics() {
    for (String channel : twitchKillMe.getMainConfigManager().getChannelsId()) {
      client.getPubSub().listenForChannelPointsRedemptionEvents(credential, channel);
      client.getPubSub().listenForHypeTrainEvents(credential, channel);
      client.getPubSub().listenForCheerEvents(credential, channel);
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
}
