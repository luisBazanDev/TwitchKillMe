package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.List;

public class PlaceReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    for(String key : settings.getConfigurationSection("blocks").getKeys(false)) {
      Location center = p.getLocation();
      List<Integer> cords = settings.getIntegerList("blocks."+key+".cords");
      try {
        Material material = Material.valueOf(settings.getString("blocks."+key+".material"));
        center.getWorld().getBlockAt(center.add(cords.get(0), cords.get(1), cords.get(2))).setType(material);
      } catch (NullPointerException | IllegalArgumentException e) {
        TwitchKillMe.reportError(String.format(
                "Material error on reward: %s - BlockId: %s",
                reward.getName(),
                key
        ));
      }
    }
  }
}
