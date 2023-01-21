package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;
import pe.bazan.luis.plugins.twitchkillme.instances.RewardFormat;

import java.text.DecimalFormat;

public class FreezeReward {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    final int time = settings.getInt("time", 0);
    switch (settings.getString("alert").toLowerCase()) {
      case "actionbar":
        new AlertActionBar(time, p);
        break;
      case "bossbar":
        new AlertBossBar(time, p);
        break;
    }
    new FreezePlayer(time, p);
  }

  private static class FreezePlayer extends BukkitRunnable {
    final Player player;
    final Location location;
    double time;

    public FreezePlayer(int time, Player p) {
      this.player = p;
      this.location = p.getLocation();
      this.time = time;
      runTaskTimer(TwitchKillMe.getInstance(), 0, 1L);
    }

    public void run() {
      player.teleport(location);
      if(time <= 0) {
        cancel();
      }
      this.time -= 0.05;
    }
  }

  private static class AlertActionBar extends BukkitRunnable {
    final int totalTime;
    final Player player;
    final DecimalFormat decimalFormat = new DecimalFormat("00");
    int time;
    public AlertActionBar(int time, Player player) {
      this.totalTime = time;
      this.player = player;
      this.time = time;
      runTaskTimer(TwitchKillMe.getInstance(), 0, 20L);
    }

    @Override
    public void run() {
      player.sendActionBar(MessageFormat.formatMC(String.format(
              "&bFreeze &e%ss",
              decimalFormat.format(time)
      )));
      if(time <= 0) {
        player.sendActionBar(MessageFormat.formatMC(""));
        cancel();
        return;
      }
      this.time--;
    }
  }

  private static class AlertBossBar extends BukkitRunnable {
    final int totalTime;
    final BossBar bossBar;
    final Player player;
    final DecimalFormat decimalFormat = new DecimalFormat("00");
    int time;
    public AlertBossBar(int time, Player player) {
      this.totalTime = time;
      this.player = player;
      this.time = time;
      this.bossBar = Bukkit.createBossBar(
              MessageFormat.formatMCTxt(String.format("&bFreeze &e%ss", decimalFormat.format(time))),
              BarColor.WHITE,
              BarStyle.SOLID
      );
      bossBar.addPlayer(player);
      runTaskTimer(TwitchKillMe.getInstance(), 0, 20L);
    }

    @Override
    public void run() {
      bossBar.setProgress((double) time / totalTime);
      System.out.println(bossBar.getProgress());
      bossBar.setTitle(MessageFormat.formatMCTxt(String.format("&bFreeze &e%ss", decimalFormat.format(time))));
      if(time <= 0) {
        bossBar.removeAll();
        cancel();
        return;
      }
      this.time--;
    }
  }
}
