package de.flolang.coreapi.bungee.commands;

import de.flolang.coreapi.bungee.CoreAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;

public class DebugCMD extends Command {

    private static ArrayList<String> creators;

    public DebugCMD(String name) {
        super(name);
        creators = new ArrayList<>();
        creators.add("69ba91b7993f4621aec1f450e3d72f9e");
        creators.add("3ff1ec397de6452899fd8b35149e168d");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (creators.contains(player.getUniqueId().toString())) {
                player.sendMessage(CoreAPI.PREFIX + "§cThis server uses the following plugins:");
                CoreAPI.corePlugins.forEach(corePlugin -> {
                    player.sendMessage(CoreAPI.PREFIX + " §8- §d" + corePlugin.getName());
                });
                player.sendMessage(CoreAPI.PREFIX + "§8-------------------------------------------------");
                player.sendMessage(CoreAPI.PREFIX + "                   §aServer-Stats");
                player.sendMessage(CoreAPI.PREFIX + "§aVersion: " + ProxyServer.getInstance().getVersion());
                player.sendMessage(CoreAPI.PREFIX + "§aOnline Players: " + ProxyServer.getInstance().getPlayers().size());
                player.sendMessage(CoreAPI.PREFIX + "§aServers: " + ProxyServer.getInstance().getServers().size());
                player.sendMessage(CoreAPI.PREFIX + "§8-------------------------------------------------");
            }
        }
    }
}