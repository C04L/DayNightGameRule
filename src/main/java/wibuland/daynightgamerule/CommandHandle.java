package wibuland.daynightgamerule;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("deprecation")
public class CommandHandle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0 && sender instanceof Player) {
            sender.sendMessage(ChatColor.YELLOW + "To reload config use /dngr reload");
        } else if (!(sender instanceof Player) && args.length == 0) {
            Bukkit.getConsoleSender().sendMessage("To reload config use /dngr reload");
        } else if (args[0].equals("reload") && args.length >= 1) {
            if (!(sender instanceof Player)) {
                DayNightGameRule.getInstance().reloadConfig();
                DayNightGameRule.getInstance().saveConfig();
                Bukkit.getConsoleSender().sendMessage("[DayNightGameRule] Reloaded successfully");
                return true;
            } else if (sender.hasPermission("daynightgamrule.reload")) {
                DayNightGameRule.getInstance().reloadConfig();
                DayNightGameRule.getInstance().saveConfig();
                sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD +"[DayNightGameRule] Reloaded successfully");
            } else {
                sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD +"[DayNightGameRule] You don't have permission to use this command");
                return false;
            }
            return true;
        }
        return true;
    }
}
