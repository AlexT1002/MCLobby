package de.alextom.mcLobby.listener.playerListener;

import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class PlayerPickupItemListener implements Listener {
    @EventHandler
    public void playerPickupItem(EntityPickupItemEvent event){
        event.setCancelled(!BuildSystem.isPlayerInBuildmode((Player) event.getEntity()));
    }
}
