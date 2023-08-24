package me.clip.placeholderapi.external;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Deprecated
public abstract class EZPlaceholderHook extends PlaceholderExpansion {

    private final String identifier;

    private final String plugin;
    private final Plugin pluginInstance;

    public EZPlaceholderHook(Plugin plugin, String identifier) {
        Objects.requireNonNull(plugin, "Plugin can not be null!");
        Objects.requireNonNull(identifier, "Placeholder name can not be null!");
        this.identifier = identifier;
        this.pluginInstance = plugin;  // Added
        this.plugin = plugin.getName();
    }

    @Override
    public @NotNull String getVersion() {
        return pluginInstance.getDescription().getVersion();
    }

    @NotNull
    @Override
    public String getIdentifier() {
        return identifier;
    }

    public boolean isHooked() {
        return PlaceholderAPI.getRegisteredPlaceholderPlugins().contains(identifier);
    }

    public boolean hook() {
        return super.register();
    }

    public String getPlaceholderName() {
        return identifier;
    }

    public String getPluginName() {
        return plugin;
    }
}