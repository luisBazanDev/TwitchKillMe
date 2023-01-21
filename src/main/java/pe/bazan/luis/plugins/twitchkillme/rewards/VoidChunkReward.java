package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

public class VoidChunkReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    Location loc = p.getLocation();
    Chunk chunk = loc.getChunk();
    for(int y = loc.getWorld().getMinHeight(); y <= loc.getWorld().getMaxHeight(); y++) {
      for (int x = 0; x < 16; x++) {
        for (int z = 0; z < 16; z++) {
          chunk.getBlock(x, y, z).setType(Material.AIR);
        }
      }
    }
  }
}
