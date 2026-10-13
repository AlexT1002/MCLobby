package de.alextom.mcLobby.listener.inventoryListener;

import de.alextom.mcLobby.MCLobby;
import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void inventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getClickedInventory() == MCLobby.getNavigatorInventory().getInventory()){
            if(event.getCurrentItem() != null && MCLobby.getNavigatorInventory().getNavigatorItemsCommands().containsKey(event.getCurrentItem())){
                player.performCommand(MCLobby.getNavigatorInventory().getNavigatorItemsCommands().get(event.getCurrentItem()).replace("/", ""));
            }
        }
        if(event.getClickedInventory() == MCLobby.getSettingsInventory().getInventory()){
            if(event.getCurrentItem() != null && MCLobby.getSettingsInventory().getSettingsItemsCommands().containsKey(event.getCurrentItem())){
                player.performCommand(MCLobby.getSettingsInventory().getSettingsItemsCommands().get(event.getCurrentItem()).replace("/", ""));
            }
        }
        if(event.getClickedInventory() == MCLobby.getUtilsInventory().getInventory()){
            if(event.getCurrentItem() != null && MCLobby.getUtilsInventory().getUtilsItemsCommands().containsKey(event.getCurrentItem())){
                player.performCommand(MCLobby.getUtilsInventory().getUtilsItemsCommands().get(event.getCurrentItem()).replace("/", ""));
            }
        }

        event.setCancelled(!BuildSystem.isPlayerInBuildmode(player));
    }
}
