package pe.bazan.luis.plugins.twitchkillme.rewards;

import feign.CollectionFormat;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;
import pe.bazan.luis.plugins.twitchkillme.utils.Locations;
import pe.bazan.luis.plugins.twitchkillme.utils.Randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PotionRain {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    double radius = settings.getDouble("radius", 3);
    if(!settings.isList("effects")) {
      p.sendMessage(MessageFormat.formatMC(TwitchKillMe.getInstance().getMsg("all.reward-config-error")));
      return;
    }
    List<Color> colors = Arrays.asList(new Color[]{Color.AQUA, Color.RED, Color.GREEN, Color.YELLOW, Color.GRAY});
    List<String> effects = settings.getStringList("effects");
    try {
      for(String effect : effects) {
        String[] data = effect.split(";");
        if (data.length != 4) {
          p.sendMessage(MessageFormat.formatMC(TwitchKillMe.getInstance().getMsg("all.reward-config-error")));
          return;
        }
        Location loc = Locations.radiusLocationXZ(p.getLocation().add(0, 3, 0), radius);
        ThrownPotion thrownPotion = loc.getWorld().spawn(loc, ThrownPotion.class);
        PotionMeta potionMeta = thrownPotion.getPotionMeta();
        potionMeta.setColor(Randomizer.randomizerList(colors));
      }
    } catch (Exception e) {
      p.sendMessage(MessageFormat.formatMC(TwitchKillMe.getInstance().getMsg("all.reward-config-error")));
      return;
    }
  }
}
