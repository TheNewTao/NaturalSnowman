package me.thenewtao.snowman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Snowman extends JavaPlugin {

	public boolean snowGolem = true;
	public String name = "Dinine Golem";

	Events events = new Events(this);

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(events, this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player && sender != null) {
			if (cmd.getName().equalsIgnoreCase("snowman") && sender.hasPermission("snowman.command")) {
				Player p = (Player) sender;
				if (args.length == 0) {
					if (snowGolem) {
						snowGolem = false;
						p.sendMessage(
								ChatColor.WHITE + ChatColor.BOLD.toString() + "Snowmem random spawning has been "
										+ ChatColor.RED + ChatColor.BOLD.toString() + "disabled!");
					} else {
						snowGolem = true;
						p.sendMessage(
								ChatColor.WHITE + ChatColor.BOLD.toString() + "Snowmen random spawning has been "
										+ ChatColor.GREEN + ChatColor.BOLD.toString() + "enabled!");
					}
				}
				else if (args.length == 2 && args[0].equalsIgnoreCase("setname")) {
					name = args[1];
					p.sendMessage(ChatColor.WHITE + ChatColor.BOLD.toString() + "You have set snowman names to "
							+ ChatColor.RED + ChatColor.BOLD.toString() + name);
				}
			}
		}
		return true;
	}
}
