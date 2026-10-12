package de.alextom.mcLobby.listener.playerListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {
    @EventHandler
    public void playerDropItem(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
}
