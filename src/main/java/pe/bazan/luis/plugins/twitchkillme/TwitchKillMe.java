package pe.bazan.luis.plugins.twitchkillme;

import org.bukkit.plugin.java.JavaPlugin;
import pe.bazan.luis.plugins.twitchkillme.configs.MainConfigManager;

public final class TwitchKillMe extends JavaPlugin {
  private MainConfigManager mainConfigManager;

  @Override
  public void onEnable() {
    // Plugin startup logic

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public MainConfigManager getMainConfigManager() {
    return mainConfigManager;
  }
}
