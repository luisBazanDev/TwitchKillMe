package pe.bazan.luis.plugins.twitchkillme.events;

import com.github.twitch4j.pubsub.events.ChannelBitsEvent;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

public class BitsEvent {
  public static void onCheer(ChannelBitsEvent e) {
    final String channelId = e.getData().getChannelId();
    final String username = e.getData().getUserName();
    final int amount = e.getData().getTotalBitsUsed();
    TwitchKillMe.getInstance().getRewardsConfig().getRewards().forEach((s, reward) -> {
      if(!reward.activeBits(amount)) return;

      for(Player p : TwitchKillMe.getInstance().getMainConfigManager().getPlayers()) {
        reward.runReward(username, String.valueOf(amount), TwitchKillMe.getInstance().getMsg("events.bits"), channelId, p);
      }
    });
  }
}
