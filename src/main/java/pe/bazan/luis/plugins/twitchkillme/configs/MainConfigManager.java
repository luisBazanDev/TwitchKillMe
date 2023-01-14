package pe.bazan.luis.plugins.twitchkillme.configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

import java.util.ArrayList;
import java.util.List;

public class MainConfigManager {
  private TwitchKillMe plugin;
  private CustomConfig configFile;
  public MainConfigManager(TwitchKillMe plugin){
    this.plugin = plugin;
    registerConfig();
  }

  public void registerConfig(){
    configFile = new CustomConfig("config.yml", plugin);
    configFile.registerConfig();
  }

  public void load(){
    FileConfiguration config = configFile.getConfig();
  }

  public void reloadConfig(){
    configFile.reloadConfig();
    load();
  }

  public String getTwitchToken() {
    return configFile.getConfig().getString("twitch.token");
  }
  public String getChatToken() {
    if(!configFile.getConfig().getString("twitch.chat-token").equals("")) return configFile.getConfig().getString("twitch.chat-token");
    return getTwitchToken();
  }

  public List<Player> getPlayers() {
    List<Player> playerList = new ArrayList<>();
    configFile.getConfig().getStringList("players").forEach(s -> {
      if(Bukkit.getPlayer(s) != null) playerList.add(Bukkit.getPlayer(s));
    });
    return playerList;
  }

  public List<String> getChannels() {
    return configFile.getConfig().getStringList("twitch.channels");
  }
}
