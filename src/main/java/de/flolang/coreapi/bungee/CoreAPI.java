package de.flolang.coreapi.bungee;

import de.flolang.coreapi.bungee.commands.DebugCMD;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.ArrayList;

public class CoreAPI extends Plugin {

    public static ArrayList<CorePlugin> corePlugins = new ArrayList<>();

    public static final String PREFIX = "§bFloLang §8» §r";
    public static Plugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getProxy().getPluginManager().registerCommand(this, new DebugCMD("debug"));
        getProxy().getConsole().sendMessage(PREFIX + "§aCoreAPI enabled!");
    }

    public static void registerPlugin(CorePlugin corePlugin) {
        CoreAPI.INSTANCE.getProxy().getConsole().sendMessage(CoreAPI.PREFIX + "§d" + corePlugin.name + " §ahas been activated.");
        corePlugin.enabled();
        corePlugins.add(corePlugin);
    }

    @Override
    public void onDisable() {
        getProxy().getConsole().sendMessage(PREFIX + "§cCoreAPI disabled!");
        corePlugins.forEach(CorePlugin::disabled);
    }
}
