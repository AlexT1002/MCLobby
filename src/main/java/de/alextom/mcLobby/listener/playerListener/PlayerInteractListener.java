package de.alextom.mcLobby.listener.playerListener;

import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void playerInteract(PlayerInteractEvent event){
        event.setCancelled(!BuildSystem.isPlayerInBuildmode(event.getPlayer()));
    }
}
