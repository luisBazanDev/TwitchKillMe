package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

public class TpReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    Location center = p.getLocation();
    switch (settings.getString("center").toLowerCase()) {
      case "world":
        center = p.getLocation().getWorld().getSpawnLocation();
        break;
      default:
        if(settings.getString("center").startsWith("world:")){
          World world = Bukkit.getWorld(settings.getString("center").split(":")[1]);
          if(world != null) center = world.getSpawnLocation();
        }
    }
    p.teleport(center.add(
            generateCords(settings.getConfigurationSection("x")),
            generateCords(settings.getConfigurationSection("y")),
            generateCords(settings.getConfigurationSection("z"))
    ));
  }

  public static double generateCords(ConfigurationSection cord) {
    return Math.random() * (cord.getDouble("max") - cord.getDouble("min")) + cord.getDouble("min");
  }
}
