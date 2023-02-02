package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.List;
import java.util.Random;

public class RandomReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    List<String> rewards = settings.getStringList("rewards");
    Reward executableReward = TwitchKillMe.getInstance().getRewardsConfig().getRewards().get(
            rewards.get(new Random().nextInt(rewards.size()))
    );

    if(executableReward == null) {
      p.sendMessage(MessageFormat.formatMC(TwitchKillMe.getInstance().getMsg("rewards.reward-error")));
      return;
    }

    executableReward.runReward(format.getUsername(), format.getAmount(), format.getMethod(), format.getChannelId(), p);
  }
}
