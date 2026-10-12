package de.alextom.mcLobby.listener.playerListener;

import de.alextom.mcLobby.MCLobby;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void playerQuit(PlayerQuitEvent event){
        if(MCLobby.getMessageConfig().getString("QuitMessage") != null){
            String quitMessage = Objects.requireNonNull(MCLobby.getMessageConfig().getString("QuitMessage")).replace("%player%", event.getPlayer().getName());
            Component component = LegacyComponentSerializer.legacySection().deserialize(quitMessage);
            event.quitMessage(component);
        }else{
            event.quitMessage(null);
        }
    }
}
