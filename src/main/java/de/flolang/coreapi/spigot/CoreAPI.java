package de.flolang.coreapi.spigot;

import de.flolang.coreapi.spigot.commands.DebugCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public class CoreAPI extends JavaPlugin {

    public static ArrayList<CorePlugin> corePlugins = new ArrayList<>();

    public static final String PREFIX = "§bFloLang §8» §r";

    public static Plugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aCoreAPI enabled!");
        getCommand("debugs").setExecutor(new DebugCMD());
    }

    public static void registerPlugin(CorePlugin corePlugin) {
        Bukkit.getConsoleSender().sendMessage(CoreAPI.PREFIX + "§d" + corePlugin.name + " §ahas been activated.");
        corePlugin.enabled();
        corePlugins.add(corePlugin);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cCoreAPI disabled!");
        corePlugins.forEach(CorePlugin::disabled);
    }

}
