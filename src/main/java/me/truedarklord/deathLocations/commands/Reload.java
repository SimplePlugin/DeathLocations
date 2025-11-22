package me.truedarklord.deathLocations.commands;

import me.truedarklord.deathLocations.DeathLocations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    private final DeathLocations plugin = DeathLocations.getPlugin(DeathLocations.class);

    public Reload() {
        plugin.getCommand("reload").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        return true;
    }
}
