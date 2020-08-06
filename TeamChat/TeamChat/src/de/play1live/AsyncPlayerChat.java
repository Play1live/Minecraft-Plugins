package de.play1live;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class AsyncPlayerChat implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();

		if (player.hasPermission("teamchat.use")) {
			if (e.getMessage().startsWith(plugin.getConfig().getString("usage"))) {
				String msg = e.getMessage().replace(plugin.getConfig().getString("usage")+" ", "").replace(plugin.getConfig().getString("usage"), "");
				e.setCancelled(true);

				for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
					if (onlinePlayer.hasPermission("teamchat.use")) {
						Player member = onlinePlayer;
						
						String prefix = plugin.getConfig().getString("prefix").replaceAll("&","§");
						String format = plugin.getConfig().getString("format");
						
						member.sendMessage(format.replace("%PREFIX%", prefix).replace("%PLAYER%", member.getName()).replace("%MSG%", msg));
					}
				}
			} else {
				e.setCancelled(false);
			}
		}

	}
}
