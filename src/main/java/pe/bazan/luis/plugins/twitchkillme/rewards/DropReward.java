package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.util.ArrayList;
import java.util.List;

public class DropReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    List<String> slots = new ArrayList<>();
    if(settings.getString("slot") != null) {
      slots.add(settings.getString("slot"));
    } else if (settings.getStringList("slots") != null) {
      settings.getStringList("slots").forEach((slot) -> {
        slots.add(slot);
      });
    }
    slots.forEach((slot) -> {
      dropItem(slot, p);
    });
  }

  @Nullable
  private static void dropItem(String slot, Player p) {
    ItemStack itemStack;
    switch (slot) {
      case "main-hand":
        itemStack = p.getInventory().getItemInMainHand();
        p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
        break;
      case "off-hand":
        itemStack = p.getInventory().getItemInOffHand();
        p.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
        break;
      case "helmet":
        itemStack = p.getInventory().getHelmet();
        p.getInventory().setHelmet(new ItemStack(Material.AIR));
        break;
      case "chestplate":
        itemStack = p.getInventory().getChestplate();
        p.getInventory().setChestplate(new ItemStack(Material.AIR));
        break;
      case "leggings":
        itemStack = p.getInventory().getLeggings();
        p.getInventory().setLeggings(new ItemStack(Material.AIR));
        break;
      case "boots":
        itemStack = p.getInventory().getBoots();
        p.getInventory().setBoots(new ItemStack(Material.AIR));
        break;
      case "random":
        ItemStack[] inventory = p.getInventory().getContents();
        int index = (int) Math.floor(Math.random() * inventory.length);
        itemStack = inventory[index];
        inventory[index] = new ItemStack(Material.AIR);
        p.getInventory().setContents(inventory);
        break;
      default:
        itemStack = p.getInventory().getItem(Integer.parseInt(slot));
    }
    p.getWorld().dropItemNaturally(p.getLocation(), itemStack);
  }
}
