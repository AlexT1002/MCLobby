package de.alextom.mcLobby.listener.blockListener;

import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void blockPlace(BlockPlaceEvent event){
        event.setCancelled(!BuildSystem.isPlayerInBuildmode(event.getPlayer()));
    }
}
