package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Animatronics {
    private final JavaPlugin plugin;

    public Animatronics(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void spawnAnimatronics() {
        new BukkitRunnable() {
            @Override
            public void run() {
                spawnAnimatronic("Puppet", EntityType.ZOMBIE);
                spawnAnimatronic("Glamrock", EntityType.SKELETON);
                spawnAnimatronic("Nightmare", EntityType.ENDERMAN);
            }
        }.runTaskTimer(plugin, 0L, 20L * 60); // Spawn every minute
    }

    private void spawnAnimatronic(String name, EntityType type) {
        Bukkit.getWorlds().forEach(world -> {
            Location spawnLocation = world.getSpawnLocation().add(
                Math.random() * 100 - 50,
                0,
                Math.random() * 100 - 50
            );
            LivingEntity animatronic = (LivingEntity) world.spawnEntity(spawnLocation, type);
            animatronic.setCustomName(name);
            animatronic.setCustomNameVisible(true);
        });
    }
}