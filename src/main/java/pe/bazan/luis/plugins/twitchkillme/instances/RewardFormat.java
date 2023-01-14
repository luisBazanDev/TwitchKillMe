package pe.bazan.luis.plugins.twitchkillme.instances;

import org.bukkit.ChatColor;

public class RewardFormat {
  final private String name;
  final private String player;
  final private String username;
  final private String amount;
  final private String method;
  final private String channelId;

  public RewardFormat(
          String name,
          String username,
          String amount,
          String method,
          String channelId,
          String player
  ) {
    this.name = name;
    this.username = username;
    this.amount = amount;
    this.method = method;
    this.player = player;
    this.channelId = channelId;
  }

  public String replace(String text) {
    text = text.replaceAll("%name%", name);
    text = text.replaceAll("%username%", username);
    text = text.replaceAll("%amount%", amount);
    text = text.replaceAll("%method%", method);
    text = text.replaceAll("%player%", player);
    return text;
  }

  public String replaceWithColors(String text) {
    return ChatColor.translateAlternateColorCodes('&', replace(text));
  }

  public String getName() {
    return name;
  }

  public String getPlayer() {
    return player;
  }

  public String getUsername() {
    return username;
  }

  public String getAmount() {
    return amount;
  }

  public String getMethod() {
    return method;
  }

  public String getChannelId() {
    return channelId;
  }
}
