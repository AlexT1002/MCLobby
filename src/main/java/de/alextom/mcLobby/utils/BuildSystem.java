package de.alextom.mcLobby.utils;

import de.alextom.mcLobby.items.JoinItems;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class BuildSystem {
    private static final Map<Player, Boolean> playerBuildMode = new HashMap<>();


    public static void setPlayerBuildMode(Player player, Boolean key){
        playerBuildMode.put(player, key);
    }

    public static void removePlayerBuildmode(Player player){
        playerBuildMode.remove(player);
    }

    public static void changePlayerBuildmode(Player player){
        if(isPlayerInBuildmode(player)){
            playerBuildMode.replace(player, false);
            JoinItems.giveJoinItems(player);
        }else{
            playerBuildMode.replace(player, true);
            player.getInventory().clear();
        }
    }

    public static boolean isPlayerInBuildmode(Player player){
        if(playerBuildMode.containsKey(player)){
            return playerBuildMode.get(player);
        }
        return false;
    }
}
