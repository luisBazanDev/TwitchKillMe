package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.ArrayList;
import java.util.List;

public class GiveReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    ItemStack itemStack = new ItemStack(Material.valueOf(settings.getString("material")));
    ItemMeta itemMeta = itemStack.getItemMeta();
    if(settings.getInt("custom-model", 0) != 0) {
      itemMeta.setCustomModelData(settings.getInt("custom-model"));
    }
    if(settings.getInt("amount", 0) != 0) {
      itemStack.setAmount(settings.getInt("amount"));
    }
    if(settings.getString("name") != null) {
      itemMeta.setDisplayName(MessageFormat.formatMCTxt(settings.getString("name")));
    }
    if(settings.getStringList("lore") != null) {
      List<String> lore = new ArrayList<>();
      settings.getStringList("lore").forEach((line) -> {
        lore.add(MessageFormat.formatMCTxt(line));
      });
      itemMeta.setLore(lore);
    }

    itemStack.setItemMeta(itemMeta);

    final int slot = settings.getInt("slot", -1);
    if(slot != -1) {
      ItemStack otherItem = p.getInventory().getItem(slot);
      p.getInventory().setItem(slot, itemStack);
      p.getInventory().addItem(otherItem);
    } else {
      p.getInventory().addItem(itemStack);
    }
  }
}
