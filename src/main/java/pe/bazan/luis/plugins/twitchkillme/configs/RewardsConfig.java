package pe.bazan.luis.plugins.twitchkillme.configs;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;

import java.util.HashMap;

public class RewardsConfig {
    private TwitchKillMe plugin;
    private CustomConfig configFile;
    private HashMap<String, Reward> notifications;
    public RewardsConfig(TwitchKillMe plugin) {
      this.plugin = plugin;
      registerConfig();
    }

    public void registerConfig() {
      this.configFile = new CustomConfig("rewards.yml", plugin);
      configFile.registerConfig();
    }

    public void load() {
      FileConfiguration config = configFile.getConfig();
      notifications = new HashMap<>();
      for(String key : config.getConfigurationSection("rewards").getKeys(false)) {
        ConfigurationSection rewardConfig = config.getConfigurationSection("rewards."+key);
        notifications.put(key.toLowerCase(), new Reward(rewardConfig));
      }
    }

    public void reloadConfig(){
      configFile.reloadConfig();
      load();
    }
}
