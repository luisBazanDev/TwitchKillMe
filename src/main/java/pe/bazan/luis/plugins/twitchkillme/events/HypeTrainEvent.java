package pe.bazan.luis.plugins.twitchkillme.events;

import com.github.twitch4j.pubsub.events.HypeTrainLevelUpEvent;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

public class HypeTrainEvent {
  public static void onHypeTrain(HypeTrainLevelUpEvent e) {
    final Integer lvl = e.getData().getProgress().getLevel().getValue();
    TwitchKillMe.getInstance().getRewardsConfig().getRewards().forEach((s, reward) -> {
      if(!reward.activeHypeTrain(lvl)) return;
      for(Player p : TwitchKillMe.getInstance().getMainConfigManager().getPlayers()) {
        reward.runReward("Everyone", String.valueOf(lvl), "Hype Train", p);
      }
    });
  }
}
