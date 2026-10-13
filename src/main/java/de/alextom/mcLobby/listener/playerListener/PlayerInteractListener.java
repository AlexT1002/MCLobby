package de.alextom.mcLobby.listener.playerListener;

import de.alextom.mcLobby.MCLobby;
import de.alextom.mcLobby.items.JoinItems;
import de.alextom.mcLobby.utils.BuildSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void playerInteract(PlayerInteractEvent event){
        if(event.getAction().isRightClick()){
            if(event.getItem() != null && event.getItem().equals(JoinItems.getNavigatorItem())){
                MCLobby.getNavigatorInventory().openInventory(event.getPlayer());
            }
            if(event.getItem() != null && event.getItem().equals(JoinItems.getSettingsItem())){
                MCLobby.getSettingsInventory().openInventory(event.getPlayer());
            }
            if(event.getItem() != null && event.getItem().equals(JoinItems.getUtilsItem())){
                MCLobby.getUtilsInventory().openInventory(event.getPlayer());
            }
        }
        event.setCancelled(!BuildSystem.isPlayerInBuildmode(event.getPlayer()));
    }
}
