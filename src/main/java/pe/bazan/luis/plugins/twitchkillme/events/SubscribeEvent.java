package pe.bazan.luis.plugins.twitchkillme.events;

import com.github.twitch4j.pubsub.events.ChannelSubscribeEvent;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

public class SubscribeEvent {
  public static void onSub(ChannelSubscribeEvent e) {
    final String channelId = e.getData().getChannelId();
    final String username = e.getData().getDisplayName();
    final int amount = e.getData().getCumulativeMonths();
    TwitchKillMe.getInstance().getRewardsConfig().getRewards().forEach((s, reward) -> {
      if(!reward.activeSub(amount)) return;

      for(Player p : TwitchKillMe.getInstance().getMainConfigManager().getPlayers()) {
        reward.runReward(username, String.valueOf(amount), TwitchKillMe.getInstance().getMsg("events.sub"), channelId, p);
      }
    });
  }
}
