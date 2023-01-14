package pe.bazan.luis.plugins.twitchkillme.configs;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Notification;

import java.util.HashMap;

public class NotificationsConfig {
  private TwitchKillMe plugin;
  private CustomConfig configFile;
  private HashMap<String, Notification> notifications;
  public NotificationsConfig(TwitchKillMe plugin) {
    this.plugin = plugin;
    registerConfig();
  }

  public void registerConfig() {
    this.configFile = new CustomConfig("notifications.yml", plugin);
    configFile.registerConfig();
  }

  public void load(){
    FileConfiguration config = configFile.getConfig();
    notifications = new HashMap<>();
    for(String key : config.getConfigurationSection("notifications").getKeys(false)) {
      ConfigurationSection notificationConfig = config.getConfigurationSection("notifications."+key);
      notifications.put(key.toLowerCase(), new Notification(notificationConfig));
    }
  }

  public void reloadConfig() {
    configFile.reloadConfig();
    load();
  }
}
