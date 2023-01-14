package pe.bazan.luis.plugins.twitchkillme.instances;

import net.kyori.adventure.title.Title;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

import java.time.Duration;

public class Notification {
  private String title;
  private String subtitle;
  private Title.Times titleTimes;
  private String actionbar;
  private String twitch;
  private Sound sound;
  private float pitch;
  private float volume;
  public Notification(ConfigurationSection conf) {
    this.title = conf.getString("minecraft.title.content");
    this.subtitle = conf.getString("minecraft.subtitle");
    this.titleTimes = Title.Times.times(
            Duration.ofMillis(conf.getInt("minecraft.title.fadein") * 50),
            Duration.ofMillis(conf.getInt("minecraft.title.stay") * 50),
            Duration.ofMillis(conf.getInt("minecraft.title.fadeout") * 50)
    );
    this.actionbar = conf.getString("minecraft.actionbar");
    this.twitch = conf.getString("twitch");
    this.sound = Sound.valueOf(conf.getString("sound.sound"));
    this.pitch = (float) conf.getDouble("sound.pitch");
    this.volume = (float) conf.getDouble("sound.volume");
  }

  public void notifyPlayer(RewardFormat formatter, Player p) {
    final Title titleComponent = Title.title(
            MessageFormat.formatMC(formatter.replace(title)),
            MessageFormat.formatMC(formatter.replace(subtitle)),
            titleTimes
    );
    p.showTitle(titleComponent);
    p.playSound(p.getLocation(), sound, pitch, volume);
    p.sendActionBar(MessageFormat.formatMC(formatter.replace(actionbar)));
  }

  public void notifyTwitch(RewardFormat formatter) {
    TwitchKillMe.getInstance().sayTwitch(
            TwitchKillMe.getInstance().getMainConfigManager().getChannels().get(formatter.getChannelId()),
            formatter.replace(twitch)
    );
  }
}
