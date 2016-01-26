package me.thenewtao.snowman;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.thenewtao.snowmancmd.SnowmanCmd;
import me.thenewtao.snowmanlistener.CreatureSpawn;

public class Snowman extends JavaPlugin {

	private boolean snowGolem = true;
	private String name = "Dinine Golem";

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new CreatureSpawn(this), this);
		Bukkit.getPluginCommand("snowman").setExecutor(new SnowmanCmd(this));
	}

	public boolean isSnowGolemEnabled() {
		return snowGolem;
	}

	public void setSnowGolemEnabled(boolean enableOrDisable) {
		snowGolem = enableOrDisable;
	}

	public String getSnowGolemName() {
		return name;
	}

	public void setSnowGolemName(String name) {
		this.name = name;
	}

}
