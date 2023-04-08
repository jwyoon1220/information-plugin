package org.github.jwyoon1220.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("information").setExecutor(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private class iinformation implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (command.getName().equalsIgnoreCase("information")) {
                if (args.length > 0) {
                    String message = String.join(" ", args);
                    String notice = ChatColor.GREEN + "-------공지사항--------\n" + ChatColor.GREEN + message;
                    Bukkit.broadcastMessage(ChatColor.YELLOW + notice);
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "Usage: /information <할말>");
                    return true;
                }
            }
            return false;
        }
    }
}

