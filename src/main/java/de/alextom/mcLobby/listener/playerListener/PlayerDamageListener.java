package de.alextom.mcLobby.listener.playerListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {
    @EventHandler
    public void playerDamage(EntityDamageEvent event){
        event.setCancelled(true);
    }
}
