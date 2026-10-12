package de.alextom.mcLobby;

import de.alextom.mcLobby.commands.SetSpawnCommand;
import de.alextom.mcLobby.commands.SpawnCommand;
import de.alextom.mcLobby.listener.PlayerJoinListener;
import de.alextom.mcLobby.listener.PlayerQuitListener;
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

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(SetSpawnCommand.newCommand("setspawn"), "Set the Spawn");
            event.registrar().register(SpawnCommand.newCommand("spawn"), "teleport to spawn");
        });

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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
