package me.thenewtao.snowmancmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thenewtao.snowman.Snowman;

public class SnowmanCmd implements CommandExecutor{
	
	private Snowman main;
	
	public SnowmanCmd(Snowman main){
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player && sender != null) {
			if (cmd.getName().equalsIgnoreCase("snowman") && sender.hasPermission("snowman.command")) {
				Player p = (Player) sender;
				if (args.length == 0) {
					if (main.isSnowGolemEnabled()) {
						main.setSnowGolemEnabled(false);
						p.sendMessage(ChatColor.WHITE + ChatColor.BOLD.toString() + "Snowmem random spawning has been "
								+ ChatColor.RED + ChatColor.BOLD.toString() + "disabled!");
					} else {
						main.setSnowGolemEnabled(true);
						p.sendMessage(ChatColor.WHITE + ChatColor.BOLD.toString() + "Snowmen random spawning has been "
								+ ChatColor.GREEN + ChatColor.BOLD.toString() + "enabled!");
					}
				} else if (args.length == 2 && args[0].equalsIgnoreCase("setname")) {
					main.setSnowGolemName(args[1]);
					p.sendMessage(ChatColor.WHITE + ChatColor.BOLD.toString() + "You have set snowman names to "
							+ ChatColor.RED + ChatColor.BOLD.toString() + main.getSnowGolemName());
				}
			}
		}
		return true;
	}

}
