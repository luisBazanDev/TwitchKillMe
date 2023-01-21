package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.List;

public class ConsoleCommandReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format)  {
    final int interval = settings.getInt("interval", 0);
    final List<String> commands = settings.getStringList("commands");
    if(commands == null) return;
    int index = 0;
    for(String cmd : commands) {
      Bukkit.getScheduler().runTaskLater(TwitchKillMe.getInstance(), () -> {
        String command = format.replace(cmd);
        TwitchKillMe.getInstance().getServer().dispatchCommand(
                TwitchKillMe.getInstance().getServer().getConsoleSender(),
                command
        );
      }, index * interval);
      index++;
    }
  }
}
