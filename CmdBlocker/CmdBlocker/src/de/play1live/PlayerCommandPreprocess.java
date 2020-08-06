package de.play1live;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocess implements Listener {

	public FileConfiguration config = Main.getPlugin(Main.class).getConfig();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPreprocess(PlayerCommandPreprocessEvent e) {
		
		if (e.getPlayer().hasPermission("bypass.cmdblocker")) {
			return;
		}
		
		List<String> bcmd = config.getStringList("BlockedCommands");
		String msg = e.getMessage().split(" ", 2)[0];
		
		if (msg.startsWith("/")) {
			msg = msg.substring(1);
		}

		if (bcmd.contains(msg)) {
			e.getPlayer().sendMessage(config.getString("message").replaceAll("%PLAYER%", e.getPlayer().getName()).replaceAll("&", "§"));
			e.setCancelled(true);
		}
		
	}
}
