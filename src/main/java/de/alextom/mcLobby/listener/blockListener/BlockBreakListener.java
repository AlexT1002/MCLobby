package de.alextom.mcLobby.listener.blockListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        event.setCancelled(true);
    }
}
