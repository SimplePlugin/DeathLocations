package me.truedarklord.deathLocations;

import me.truedarklord.deathLocations.commands.Reload;
import me.truedarklord.deathLocations.listeners.Death;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLocations extends JavaPlugin {

    @Override
    public void onEnable() {
        Metrics metrics = new Metrics(this, 28088);

        new Reload();
        new Death();
    }

    @Override
    public void onDisable() {}
}
