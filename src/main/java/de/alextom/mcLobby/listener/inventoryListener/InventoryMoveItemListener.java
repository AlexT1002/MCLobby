package de.alextom.mcLobby.listener.inventoryListener;

import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InventoryMoveItemListener implements Listener {
    @EventHandler
    public void inventoryMoveItem(InventoryMoveItemEvent event){
        event.setCancelled(true);
    }
}
