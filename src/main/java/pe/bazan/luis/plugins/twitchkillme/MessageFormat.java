package pe.bazan.luis.plugins.twitchkillme;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;

public class MessageFormat {
  public static Component formatMC(String text) {
    return Component.text(ChatColor.translateAlternateColorCodes('&', text));
  }
  public static String formatMCTxt(String text) {
    return ChatColor.translateAlternateColorCodes('&', text);
  }
}
