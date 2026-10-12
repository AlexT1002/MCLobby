package de.alextom.mcLobby.listener.playerListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void playerDeath(PlayerDeathEvent event){
        event.setCancelled(true);
    }
}
