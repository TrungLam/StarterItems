package com.github.TrungLam;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class StarterItems extends JavaPlugin implements Listener{
	public static StarterItems plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void onDisable(){
		logger.info(this.getDescription().getFullName() + " is disabled");
	}
	public void onEnable(){
		logger.info(this.getDescription().getFullName() + " is enabled");
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if (!player.hasPlayedBefore()){
			List<String> kit = StarterItems.this.getConfig().getStringList("kit");
			ItemStack item;
			for (String k : kit){
				item = new ItemStack(Material.getMaterial(k));
				player.getInventory().addItem(item);
			}
		}
	}
}
