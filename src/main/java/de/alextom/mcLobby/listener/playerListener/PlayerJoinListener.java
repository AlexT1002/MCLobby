package de.alextom.mcLobby.listener.playerListener;

import de.alextom.mcLobby.MCLobby;
import de.alextom.mcLobby.items.JoinItems;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Location location = new Location(
                Bukkit.getWorld(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Spawnlocation.World"))),
                MCLobby.getInstance().getConfig().getDouble("Spawnlocation.x"),
                MCLobby.getInstance().getConfig().getDouble("Spawnlocation.y"),
                MCLobby.getInstance().getConfig().getDouble("Spawnlocation.z"),
                (float) MCLobby.getInstance().getConfig().getDouble("Spawnlocation.yaw"),
                (float) MCLobby.getInstance().getConfig().getDouble("Spawnlocation.pitch")
        );

        player.teleport(location);
        JoinItems.giveJoinItems(player);

        if(MCLobby.getMessageConfig().getString("JoinMessage") != null){
            String joinMessage = Objects.requireNonNull(MCLobby.getMessageConfig().getString("JoinMessage")).replace("%player%", event.getPlayer().getName());
            Component component = LegacyComponentSerializer.legacySection().deserialize(joinMessage);
            event.joinMessage(component);
        }else{
            event.joinMessage(null);
        }
    }
}
