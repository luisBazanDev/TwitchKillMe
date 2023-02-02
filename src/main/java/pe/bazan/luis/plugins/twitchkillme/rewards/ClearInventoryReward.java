package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

public class ClearInventoryReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    p.getInventory().clear();
  }
}
