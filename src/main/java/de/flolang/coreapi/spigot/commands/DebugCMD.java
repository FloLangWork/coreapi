package de.flolang.coreapi.spigot.commands;

import de.flolang.coreapi.spigot.CoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class DebugCMD implements CommandExecutor {

    private static ArrayList<String> creators;

    public DebugCMD() {
        creators = new ArrayList<>();
        creators.add("69ba91b7993f4621aec1f450e3d72f9e");
        creators.add("3ff1ec397de6452899fd8b35149e168d");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (creators.contains(player.getUniqueId().toString())) {
                player.sendMessage(CoreAPI.PREFIX + "§cThis server uses the following plugins:");
                CoreAPI.corePlugins.forEach(corePlugin -> {
                    player.sendMessage(CoreAPI.PREFIX + " §8- §d" + corePlugin.getName());
                });
                player.sendMessage(CoreAPI.PREFIX + "§8-------------------------------------------------");
                player.sendMessage(CoreAPI.PREFIX + "                   §aServer-Stats");
                player.sendMessage(CoreAPI.PREFIX + "§aVersion: " + Bukkit.getVersion());
                player.sendMessage(CoreAPI.PREFIX + "§aOnline Players: " + Bukkit.getOnlinePlayers().size());
                player.sendMessage(CoreAPI.PREFIX + "§8-------------------------------------------------");
            }
        }
        return false;
    }
}
