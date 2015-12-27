package me.thenewtao.snowman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Events implements Listener {

	Snowman main;

	public Events(Snowman main) {
		this.main = main;
	}

	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Cow || e.getEntity() instanceof Chicken || e.getEntity() instanceof Pig
				|| e.getEntity() instanceof Sheep) {
			if (main.snowGolem) {
				Entity entity = e.getEntity();
				Location location = new Location(entity.getWorld(), entity.getLocation().getX()+5, entity.getLocation().getY(), entity.getLocation().getZ());
				(Bukkit.getWorld(entity.getWorld().getName()).spawnCreature(location, EntityType.SNOWMAN)).setCustomName(ChatColor.BLUE + ChatColor.BOLD.toString() + main.name);
			}
		}
	}

}
