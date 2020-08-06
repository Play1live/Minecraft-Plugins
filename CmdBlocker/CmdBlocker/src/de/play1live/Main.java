package de.play1live;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new PlayerCommandPreprocess(), this);
	}
	
	@Override
	public void onDisable() {
	}
}
