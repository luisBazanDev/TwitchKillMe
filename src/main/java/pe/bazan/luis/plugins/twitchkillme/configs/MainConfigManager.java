package pe.bazan.luis.plugins.twitchkillme.configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainConfigManager {
  private TwitchKillMe plugin;
  private CustomConfig configFile;
  private HashMap<String, String> channels;
  public MainConfigManager(TwitchKillMe plugin){
    this.plugin = plugin;
    registerConfig();
    load();
  }

  public void registerConfig(){
    configFile = new CustomConfig("config.yml", plugin);
    configFile.registerConfig();
  }

  public void load(){
    FileConfiguration config = configFile.getConfig();
    channels = new HashMap<>();
    for(String channel : config.getStringList("twitch.channels")) {
      channels.put(channel.split("/")[1], channel.split("/")[0]);
    }
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

  public List<String> getChannelsName() {
    final List<String> channelNames = new ArrayList<>();
    channels.forEach((k, v) -> {channelNames.add(v);});
    return channelNames;
  }

  public List<String> getChannelsId() {
    final List<String> channelIds = new ArrayList<>();
    channels.forEach((k, v) -> {channelIds.add(k);});
    return channelIds;
  }

  public HashMap<String, String> getChannels() {
    return channels;
  }

  public boolean getEnable() {
    return configFile.getConfig().getBoolean("enable");
  }

  public void setEnable(boolean enable) {
    configFile.getConfig().set("enable", enable);
  }

  public String getClientId() {
    return configFile.getConfig().getString("twitch.refresh.client_id");
  }

  public String getClientSecret() {
    return configFile.getConfig().getString("twitch.refresh.client_secret");
  }

  public String getRefreshToken() {
    return configFile.getConfig().getString("twitch.refresh.refresh_token");
  }
}
