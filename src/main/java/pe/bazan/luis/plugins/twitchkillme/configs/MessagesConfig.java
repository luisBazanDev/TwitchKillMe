package pe.bazan.luis.plugins.twitchkillme.configs;

import org.bukkit.configuration.file.FileConfiguration;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

import java.util.HashMap;

public class MessagesConfig {
  private TwitchKillMe plugin;
  private CustomConfig configFile;
  public MessagesConfig(TwitchKillMe plugin){
    this.plugin = plugin;
    registerConfig();
    load();
  }

  public void registerConfig() {
    configFile = new CustomConfig("messages.yml", plugin);
    configFile.registerConfig();
  }

  public void load() {
    FileConfiguration config = configFile.getConfig();
  }

  public void reloadConfig(){
    configFile.reloadConfig();
    load();
  }

  public String get(String path) {
    return configFile.getConfig().getString(path);
  }
}
