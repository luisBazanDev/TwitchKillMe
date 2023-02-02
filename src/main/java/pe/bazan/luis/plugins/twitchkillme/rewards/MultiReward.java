package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.List;

public class MultiReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    List<String> rewards = settings.getStringList("rewards");
    rewards.forEach((k) -> {
      Reward currentReward = TwitchKillMe.getInstance().getRewardsConfig().getRewards().get(k);
      if(currentReward == null) {
        p.sendMessage(MessageFormat.formatMC(TwitchKillMe.getInstance().getMsg("rewards.reward-error")));
        return;
      }

      currentReward.runReward(format.getUsername(), format.getAmount(), format.getMethod(), format.getChannelId(), p);
    });
  }
}
