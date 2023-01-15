package pe.bazan.luis.plugins.twitchkillme.instances;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.rewards.ArmorReward;
import pe.bazan.luis.plugins.twitchkillme.rewards.GiveReward;
import pe.bazan.luis.plugins.twitchkillme.rewards.SummonReward;

public class Reward {
  private String preset;
  private String name;
  private Notification notification;
  private Integer points;
  private Integer bits;
  private Integer sub;
  private Integer subGift;
  private Integer hypeTrain;
  private ConfigurationSection settings;

  public Reward(ConfigurationSection conf) {
    this.preset = conf.getString("preset");
    this.name = conf.getString("name");
    this.notification = TwitchKillMe.getInstance().getNotificationsConfig().getNotifications().get(conf.getString("notification").toLowerCase());
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
          String channelId,
          Player p
  ) {
    RewardFormat rewardFormat = new RewardFormat(this.name, username, amount, method, channelId, p.getName());

    if(notification != null) {
      notification.notifyPlayer(rewardFormat, p);
      notification.notifyTwitch(rewardFormat);
    }

    switch (preset) {
      case "summon":
        SummonReward.run(settings, p, this, rewardFormat);
        break;
      case "give":
        GiveReward.run(settings, p, this, rewardFormat);
        break;
      case "armor":
        ArmorReward.run(settings, p, this, rewardFormat);
        break;
    }
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
