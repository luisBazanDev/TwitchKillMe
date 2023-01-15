package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.ArrayList;
import java.util.List;

public class ArmorReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    ItemStack itemStack = new ItemStack(Material.valueOf(settings.getString("material")));
    ItemMeta itemMeta = itemStack.getItemMeta();

    if(settings.isInt("custom-model")) {
      itemMeta.setCustomModelData(settings.getInt("custom-model"));
    }
    if(settings.isString("name")) {
      itemMeta.setDisplayName(format.replaceWithColors(settings.getString("name")));
    }
    if(settings.isList("lore")) {
      List<String> lore = new ArrayList<>();
      settings.getStringList("lore").forEach((line) -> {
        lore.add(format.replaceWithColors(line));
      });
      itemMeta.setLore(lore);
    }

    itemStack.setItemMeta(itemMeta);

    switch (settings.getString("slot")) {
      case "helmet":
        p.getInventory().setHelmet(itemStack);
        break;
      case "chestplate":
        p.getInventory().setChestplate(itemStack);
        break;
      case "leggings":
        p.getInventory().setLeggings(itemStack);
        break;
      case "boots":
        p.getInventory().setBoots(itemStack);
        break;
    }
  }
}
