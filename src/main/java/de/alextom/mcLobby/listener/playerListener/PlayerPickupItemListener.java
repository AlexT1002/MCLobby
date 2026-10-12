package de.alextom.mcLobby.listener.playerListener;

import io.papermc.paper.event.player.PlayerPickItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerPickupItemListener implements Listener {
    @EventHandler
    public void playerPickupItem(PlayerPickItemEvent event){
        event.setCancelled(true);
    }
}
