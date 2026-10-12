package de.alextom.mcLobby;

import de.alextom.mcLobby.commands.SetSpawnCommand;
import de.alextom.mcLobby.commands.SpawnCommand;
import de.alextom.mcLobby.listener.PlayerJoinListener;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCLobby extends JavaPlugin {
    private static MCLobby instance;

    @Override
    public void onEnable() {
        instance = this;
        this.saveResource("config.yml", false);

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(SetSpawnCommand.newCommand("setspawn"), "Set the Spawn");
            event.registrar().register(SpawnCommand.newCommand("spawn"), "teleport to spawn");
        });

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MCLobby getInstance() {
        return instance;
    }
}
