package pe.bazan.luis.plugins.twitchkillme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {
  private TwitchKillMe plugin;
  public MainCommand(TwitchKillMe plugin){
    this.plugin = plugin;
    registerCommands();
  }

  public void registerCommands() {
    plugin.getCommand("twitchkillme").setExecutor(this);
    plugin.getCommand("twitchkillme").setTabCompleter(this);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    if(!(sender instanceof Player)){
      return false;
    }

    if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
      if(sender.isOp()){
        plugin.reload();
        sender.sendMessage(MessageFormat.formatMC(
                "&aRewards loaded: &e"
                        + plugin.getRewardsConfig().getRewards().size()
        ));
        plugin.getRewardsConfig().getRewards().forEach((k, v) -> {
          sender.sendMessage(MessageFormat.formatMC(String.format(
                  "&eID: &f%s &e- Name: &f%s &e- Preset: &f%s",
                  k,
                  v.getName(),
                  v.getPreset()
          )));
        });
        sender.sendMessage(MessageFormat.formatMC("&aConfig reload!"));
      }
      return true;
    }

    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
    if(args.length == 1) {
      return new ArrayList<>(Arrays.asList("reload"));
    }
    return null;
  }
}
