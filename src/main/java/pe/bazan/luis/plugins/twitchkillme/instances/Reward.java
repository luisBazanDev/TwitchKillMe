package pe.bazan.luis.plugins.twitchkillme.instances;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Reward {
  private String preset;
  private String name;
  private String notification;
  private Integer points;
  private Integer bits;
  private Integer sub;
  private Integer subGift;
  private Integer hypeTrain;
  private ConfigurationSection settings;

  public Reward(ConfigurationSection conf) {
    this.preset = conf.getString("preset");
    this.name = conf.getString("name");
    this.notification = conf.getString("notification");
    this.points = conf.getInt("active.points");
    this.bits = conf.getInt("active.bits");
    this.sub = conf.getInt("active.sub");
    this.subGift = conf.getInt("active.subs-gifts");
    this.hypeTrain = conf.getInt("active.hypeTrain");
    this.settings = conf.getConfigurationSection("settings");
  }

  public void runReward(
          String username,
          String amount,
          String method,
          Player p
  ) {
    RewardFormat rewardFormat = new RewardFormat(this.name, username, amount, method);
  }

  public boolean activePoints(int amount) {
    if(points == null) return false;
    return amount == points;
  }

  public boolean activeBits(int amount) {
    if(bits == null) return false;
    return amount == bits;
  }

  public boolean activeSub(int months) {
    if(sub == null) return false;
    return sub == months;
  }

  public boolean activeSubGift(int amount) {
    if(subGift == null) return false;
    return subGift == amount;
  }

  public boolean activeHypeTrain(int level) {
    if(hypeTrain == null) return false;
    return hypeTrain == level;
  }
}
