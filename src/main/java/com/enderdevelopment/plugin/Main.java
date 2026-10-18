package com.enderdevelopment.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private Animatronics animatronics;

    @Override
    public void onEnable() {
        animatronics = new Animatronics(this);
        animatronics.spawnAnimatronics();
        getLogger().info("FNaF: Legacy of Afton & Nightmares plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("FNaF: Legacy of Afton & Nightmares plugin disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("craftsuit")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length > 0) {
                    String suitType = args[0].toLowerCase();
                    if (suitType.equals("springbonnie")) {
                        // Craft Spring Bonnie suit logic
                        player.sendMessage("Crafting Spring Bonnie suit...");
                        return true;
                    } else if (suitType.equals("fredbear")) {
                        // Craft Fredbear suit logic
                        player.sendMessage("Crafting Fredbear suit...");
                        return true;
                    } else {
                        player.sendMessage("Unknown suit type. Use 'springbonnie' or 'fredbear'");
                        return false;
                    }
                } else {
                    player.sendMessage("Usage: /craftsuit <suitType>");
                    return false;
                }
            } else {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
        }
        return false;
    }
}