package de.alextom.mcLobby.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class JoinItems {
    public static void giveJoinItems(Player player){
        player.getInventory().clear();
        player.getInventory().setItem(0, ItemManager.createItem(Material.NETHER_STAR, "§6§lNavigator"));
        player.getInventory().setItem(1, ItemManager.createItem(Material.BLAZE_ROD, "§6§lUtils"));
        player.getInventory().setItem(8, ItemManager.createItem(Material.COMPARATOR, "§6§lSettings"));
    }
}
