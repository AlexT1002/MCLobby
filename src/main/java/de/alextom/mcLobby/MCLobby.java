package de.alextom.mcLobby;

import de.alextom.mcLobby.World.WorldSettings;
import de.alextom.mcLobby.commands.BuildCommand;
import de.alextom.mcLobby.commands.SetSpawnCommand;
import de.alextom.mcLobby.commands.SpawnCommand;
import de.alextom.mcLobby.listener.blockListener.BlockBreakListener;
import de.alextom.mcLobby.listener.blockListener.BlockPlaceListener;
import de.alextom.mcLobby.listener.inventoryListener.InventoryClickListener;
import de.alextom.mcLobby.listener.inventoryListener.InventoryMoveItemListener;
import de.alextom.mcLobby.listener.playerListener.*;
import de.alextom.mcLobby.listener.weatherListener.WeatherChangeListener;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MCLobby extends JavaPlugin {
    private static MCLobby instance;
    private static YamlConfiguration messageConfig;
    private static String prefix;

    @Override
    public void onEnable() {
        instance = this;

        this.saveResource("config.yml", false);

        File messageFile = new File(instance.getDataFolder(), "messages.yml");
        messageConfig = YamlConfiguration.loadConfiguration(messageFile);
        if(!messageFile.exists()){
            instance.saveResource("messages.yml", false);
        }

        prefix = messageConfig.getString("prefix");


        registerCommands();
        registerEvents();

        WorldSettings.mainWorldSettings();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(SetSpawnCommand.newCommand("setspawn"), "Set the Spawn");
            event.registrar().register(SpawnCommand.newCommand("spawn"), "teleport to spawn");
            event.registrar().register(BuildCommand.newCommand("build"), "Switch Buildmode");
        });
    }

    private void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryMoveItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        this.getServer().getPluginManager().registerEvents(new WeatherChangeListener(), this);
    }

    public static MCLobby getInstance() {
        return instance;
    }
    public static YamlConfiguration getMessageConfig() {
        return messageConfig;
    }
    public static String getPrefix() {
        return prefix;
    }
}
