package pe.bazan.luis.plugins.twitchkillme;

import org.bukkit.plugin.java.JavaPlugin;
import pe.bazan.luis.plugins.twitchkillme.commands.MainCommand;
import pe.bazan.luis.plugins.twitchkillme.configs.MainConfigManager;
import pe.bazan.luis.plugins.twitchkillme.configs.MessagesConfig;
import pe.bazan.luis.plugins.twitchkillme.configs.NotificationsConfig;
import pe.bazan.luis.plugins.twitchkillme.configs.RewardsConfig;

public final class TwitchKillMe extends JavaPlugin {
  private MainConfigManager mainConfigManager;
  private MessagesConfig messagesConfig;
  private RewardsConfig rewardsConfig;
  private NotificationsConfig notificationsConfig;
  private static TwitchKillMe instance;
  private TwitchService twitchService;
  private boolean enable;

  @Override
  public void onEnable() {
    // Plugin startup logic
    instance = this;
    this.mainConfigManager = new MainConfigManager(this);
    this.notificationsConfig = new NotificationsConfig(this);
    this.rewardsConfig = new RewardsConfig(this);
    twitchService = new TwitchService(this);
    new MainCommand(this);
    this.enable = mainConfigManager.getEnable();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public void sayTwitch(String channelId, String msg) {
    twitchService.sendMessage(channelId, msg);
  }

  public MainConfigManager getMainConfigManager() {
    return mainConfigManager;
  }

  public RewardsConfig getRewardsConfig() {
    return rewardsConfig;
  }

  public NotificationsConfig getNotificationsConfig() {
    return notificationsConfig;
  }

  public static TwitchKillMe getInstance() {
    return instance;
  }

  public TwitchService getTwitchService() {
    return twitchService;
  }

  public void reload() {
    this.mainConfigManager.reloadConfig();
    this.notificationsConfig.reloadConfig();
    this.rewardsConfig.reloadConfig();
    this.messagesConfig.registerConfig();
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
    mainConfigManager.setEnable(enable);
  }

  public MessagesConfig getMessagesConfig() {
    return messagesConfig;
  }

  public String getMsg(String path) {
    return messagesConfig.get(path);
  }
}
