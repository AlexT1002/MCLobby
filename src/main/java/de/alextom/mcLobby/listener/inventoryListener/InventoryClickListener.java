package de.alextom.mcLobby.listener.inventoryListener;

import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void inventoryClick(InventoryClickEvent event){
        event.setCancelled(!BuildSystem.isPlayerInBuildmode((Player) event.getWhoClicked()));
    }
}
