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
      if(sender.hasPermission("tkm.commands.reload")){
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

    if(args.length == 1 && args[0].equalsIgnoreCase("toggle")){
      if(!sender.hasPermission("tkm.commands.toggle")) return true;
      plugin.setEnable(!plugin.isEnable());
      sender.sendMessage(MessageFormat.formatMC("&aTwitch kill me system is now " + (plugin.isEnable() ? "&aEnable" : "&cDisable")));
      return true;
    }

    if(!(sender instanceof Player)){
      return false;
    }

    if(args.length == 2 && args[0].equalsIgnoreCase("test")){
      if(!sender.hasPermission("tkm.commands.test")) return true;
      Reward reward = plugin.getRewardsConfig().getRewards().get(args[1]);
      if(reward == null) {
        sender.sendMessage(MessageFormat.formatMC(String.format("&cDon't found &e\"%s\"", args[1])));
        return false;
      }
      reward.runReward("dummy", "12", "command", plugin.getMainConfigManager().getChannelsId().get(0), (Player) sender);
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
