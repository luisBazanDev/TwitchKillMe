package pe.bazan.luis.plugins.twitchkillme.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

public class TwitchRefreshToken extends BukkitRunnable {
  public TwitchRefreshToken(long time) {
    runTaskLater(TwitchKillMe.getInstance(), (time - 500) * 20L);
  }

  @Override
  public void run() {
    TwitchKillMe.getInstance().getTwitchService().refreshToken();
  }
}
