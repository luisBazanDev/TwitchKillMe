package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;
import pe.bazan.luis.plugins.twitchkillme.utils.Locations;

public class SummonReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    final Double radius = settings.getDouble("summon-radius");
    final EntityType entityType = EntityType.valueOf(settings.getString("type"));
    final String name = format.replaceWithColors(settings.getString("name"));
    final boolean topWorld = settings.getBoolean("top-world");
    final boolean equipDefault = settings.getBoolean("equip-default");
    final double health = settings.getDouble("health");
    for(int i = 0; i < settings.getInt("amount"); i++) {
      Location loc = Locations.radiusLocationXZ(p.getLocation(), radius);
      if(topWorld) {
        Block block = loc.getWorld().getHighestBlockAt(loc);
        loc.setY(block.getY() + 1.2);
      }

      Bukkit.getScheduler().runTask(TwitchKillMe.getInstance(), () -> {
        LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, entityType, equipDefault);
        entity.setMaxHealth(health);
        entity.setHealth(health);
        entity.setCustomName(name);
      });
    }
  }
}
