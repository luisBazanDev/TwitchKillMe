package pe.bazan.luis.plugins.twitchkillme.events;

import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

public class ChannelPointsEvent {
  public static void onRewardRedeemed(RewardRedeemedEvent e) {
    final String channelId = e.getRedemption().getChannelId();
    final String username = e.getRedemption().getUser().getDisplayName();
    final int amount = (int) e.getRedemption().getReward().getCost();
    TwitchKillMe.getInstance().getRewardsConfig().getRewards().forEach((s, reward) -> {
      if(!reward.activePoints(amount)) return;

      for(Player p : TwitchKillMe.getInstance().getMainConfigManager().getPlayers()) {
        reward.runReward(username, String.valueOf(amount), "Channel points", channelId, p);
      }
    });
  }
}
