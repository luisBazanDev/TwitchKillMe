package pe.bazan.luis.plugins.twitchkillme.rewards;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
import java.util.concurrent.atomic.AtomicInteger;

public class GamemodeRewards {
  public static void run(ConfigurationSection settings, Player p, Reward reward, RewardFormat format) {
    GameMode lastMode = p.getGameMode();
    GameMode newMode = null;
    switch (settings.getString("gamemode").toLowerCase()) {
      case "survival":
        newMode = GameMode.SURVIVAL;
        break;
      case "creative":
        newMode = GameMode.CREATIVE;
        break;
      case "adventure":
        newMode = GameMode.ADVENTURE;
        break;
      case "spectator":
        newMode = GameMode.SPECTATOR;
        break;
    }
    if(newMode == null) return;
    p.setGameMode(newMode);
    AtomicInteger time = new AtomicInteger(settings.getInt("time", 0));
    switch (settings.getString("alert").toLowerCase()) {
      case "actionbar":
        new AlertActionBar(time.get(), p);
        break;
      case "bossbar":
        new AlertBossBar(time.get(), p);
        break;
    }
    Bukkit.getScheduler().runTaskLater(TwitchKillMe.getInstance(), () -> {
      p.setGameMode(lastMode);
    }, time.get() * 20);
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
              "&fGamemode &e%ss",
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
              MessageFormat.formatMCTxt(String.format("&fGamemode &e%ss", decimalFormat.format(time))),
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
      bossBar.setTitle(MessageFormat.formatMCTxt(String.format("&fGamemode &e%ss", decimalFormat.format(time))));
      if(time <= 0) {
        bossBar.removeAll();
        cancel();
        return;
      }
      this.time--;
    }
  }
}
