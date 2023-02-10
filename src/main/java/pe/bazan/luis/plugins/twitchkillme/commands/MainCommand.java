package pe.bazan.luis.plugins.twitchkillme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.twitchkillme.MessageFormat;
import pe.bazan.luis.plugins.twitchkillme.TwitchKillMe;
import pe.bazan.luis.plugins.twitchkillme.instances.Reward;

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
    if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
      if(!sender.hasPermission("tkm.commands.reload")) return false;
      sender.sendMessage(MessageFormat.formatMC(
        plugin.getMsg("all.prefix")
        + plugin.getMsg("commands.reload.preview")
      ));
      plugin.reload();
      plugin.getTwitchService().reload();
      sender.sendMessage(MessageFormat.formatMC(
        plugin.getMsg("commands.reload.title")
        + plugin.getRewardsConfig().getRewards().size()
      ));
      plugin.getRewardsConfig().getRewards().forEach((k, v) -> {
        sender.sendMessage(MessageFormat.formatMC(String.format(
          plugin.getMsg("commands.reload.format"),
            k,
            v.getName(),
            v.getPreset()
        )));
      });
      sender.sendMessage(MessageFormat.formatMC(
        plugin.getMsg("all.prefix")
        + plugin.getMsg("commands.reload.confirmation")
      ));
      return true;
    }

    if(args.length == 1 && args[0].equalsIgnoreCase("toggle")){
      if(!sender.hasPermission("tkm.commands.toggle")) return true;
      plugin.setEnable(!plugin.isEnable());
      sender.sendMessage(MessageFormat.formatMC(
              plugin.getMsg("all.prefix")
              + plugin.getMsg("commands.toggle")
              + " "
              + (plugin.isEnable() ? plugin.getMsg("all.enable") : plugin.getMsg("all.disable"))
      ));
      return true;
    }

    if(!(sender instanceof Player)){
      return false;
    }

    if(args.length == 2 && args[0].equalsIgnoreCase("test")){
      if(!sender.hasPermission("tkm.commands.test")) return true;
      Reward reward = plugin.getRewardsConfig().getRewards().get(args[1]);
      if(reward == null) {
        sender.sendMessage(MessageFormat.formatMC(String.format(plugin.getMsg("commands.test.error"), args[1])));
        return false;
      }
      reward.runReward("dummy", "12", "command", plugin.getMainConfigManager().getChannelsId().get(0), (Player) sender);
      sender.sendMessage(MessageFormat.formatMC(
              plugin.getMsg("all.prefix")
              + plugin.getMsg("commands.test.success")
      ));
      return true;
    }

    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
    if(args.length == 1) {
      return new ArrayList<>(Arrays.asList("reload", "toggle", "test"));
    }

    if(args.length == 2 && args[0].equalsIgnoreCase("test")) {
      return new ArrayList<>(plugin.getRewardsConfig().getRewards().keySet());
    }
    return null;
  }
}
