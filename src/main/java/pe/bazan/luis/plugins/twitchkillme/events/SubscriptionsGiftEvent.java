package pe.bazan.luis.plugins.twitchkillme.events;

import com.github.twitch4j.pubsub.events.ChannelSubGiftEvent;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

public class SubscriptionsGiftEvent {
  public static void onSubGift(ChannelSubGiftEvent e) {
    final String channelId = e.getData().getChannelId();
    final String username = e.getData().getDisplayName();
    final int amount = e.getData().getCount();
    TwitchKillMe.getInstance().getRewardsConfig().getRewards().forEach((s, reward) -> {
      if(!reward.activeSubGift(amount)) return;

      for(Player p : TwitchKillMe.getInstance().getMainConfigManager().getPlayers()) {
        reward.runReward(username, String.valueOf(amount), "Subscription gift", channelId, p);
      }
    });
  }
}
