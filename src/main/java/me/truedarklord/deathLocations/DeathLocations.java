package me.truedarklord.deathLocations;

import me.truedarklord.deathLocations.commands.Reload;
import me.truedarklord.deathLocations.listeners.Death;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocations extends JavaPlugin {

    @Override
    public void onEnable() {
        new Reload();
        new Death();
    }

    @Override
    public void onDisable() {}
}
