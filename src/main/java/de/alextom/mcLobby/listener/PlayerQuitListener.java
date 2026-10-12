package de.alextom.mcLobby.listener;

import de.alextom.mcLobby.MCLobby;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void playerQuit(PlayerQuitEvent event){
        if(MCLobby.getMessageConfig().getString("QuitMessage") != null){
            String quitMessage = MCLobby.getMessageConfig().getString("QuitMessage").replace("%player%", event.getPlayer().getName());
            Component component = LegacyComponentSerializer.legacySection().deserialize(quitMessage);
            event.quitMessage(component);
        }else{
            event.quitMessage(null);
        }
    }
}
