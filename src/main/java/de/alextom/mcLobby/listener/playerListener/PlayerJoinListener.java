package de.alextom.mcLobby.listener.playerListener;

import de.alextom.mcLobby.MCLobby;
import de.alextom.mcLobby.items.JoinItems;
import de.alextom.mcLobby.utils.BuildSystem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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

        player.setGameMode(Objects.requireNonNull(getGameMode()));
        player.teleport(location);
        JoinItems.giveJoinItems(player);
        BuildSystem.setPlayerBuildMode(player, false);

        if(MCLobby.getMessageConfig().getString("JoinMessage") != null){
            String joinMessage = Objects.requireNonNull(MCLobby.getMessageConfig().getString("JoinMessage")).replace("%player%", event.getPlayer().getName());
            Component component = LegacyComponentSerializer.legacySection().deserialize(joinMessage);
            event.joinMessage(component);
        }else{
            event.joinMessage(null);
        }
    }

    private GameMode getGameMode(){
        return switch (MCLobby.getInstance().getConfig().getInt("GameMode")) {
            case 0 -> GameMode.SURVIVAL;
            case 1 -> GameMode.CREATIVE;
            case 2 -> GameMode.ADVENTURE;
            case 3 -> GameMode.SPECTATOR;
            default -> null;
        };
    }
}
