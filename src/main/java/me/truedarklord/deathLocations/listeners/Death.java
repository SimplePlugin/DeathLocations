package me.truedarklord.deathLocations.listeners;

import me.truedarklord.deathLocations.DeathLocations;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Death implements Listener {

    private final DeathLocations plugin = DeathLocations.getPlugin(DeathLocations.class);

    public Death() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Location loc = event.getEntity().getLocation();

        sendDeathLocation(player, loc);
    }

    private void sendDeathLocation(Player player, Location loc) {
        String message = plugin.getConfig().getString("Death_Message", "You died at %world% x:%x% y:%y% z:%z%.");
        message = message.replaceAll("%world%", loc.getWorld().getName())
                .replaceAll("%x%", String.valueOf(loc.getBlockX()))
                .replaceAll("%y%", String.valueOf(loc.getBlockY()))
                .replaceAll("%z%", String.valueOf(loc.getBlockZ()));

        player.sendMessage(colour(message));
    }

    private static String colour(String message) {
        Matcher matcher = Pattern.compile("#[a-fA-F\\d]{6}").matcher(message);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(sb, net.md_5.bungee.api.ChatColor.of(matcher.group()).toString());
        }

        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(sb).toString());
    }

}
