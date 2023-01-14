package pe.bazan.luis.plugins.twitchkillme;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
  private TwitchKillMe plugin;
  public MainCommand(TwitchKillMe plugin){
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    if(!(sender instanceof Player)){
      return false;
    }

    if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
      if(sender.isOp()){
        //plugin.getMainConfigManager().reloadConfig();
      }
      return true;
    }

    return true;
  }
}
