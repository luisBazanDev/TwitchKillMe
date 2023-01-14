package pe.bazan.luis.plugins.twitchkillme;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.pubsub.events.HypeTrainLevelUpEvent;
import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;
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
  }

  public void registerEvents() {
    client.getEventManager().onEvent(HypeTrainLevelUpEvent.class, HypeTrainEvent::onHypeTrain);
    client.getEventManager().onEvent(RewardRedeemedEvent.class, ChannelPointsEvent::onRewardRedeemed);
  }

  public void subscribeTopics() {
    for (String channel : twitchKillMe.getMainConfigManager().getChannels()) {
      client.getPubSub().listenForChannelPointsRedemptionEvents(credential, channel);
      client.getPubSub().listenForHypeTrainEvents(credential, channel);
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
}
