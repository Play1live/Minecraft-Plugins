package de.play1live;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new AsyncPlayerChat(), this);
		
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
	}
	
}
