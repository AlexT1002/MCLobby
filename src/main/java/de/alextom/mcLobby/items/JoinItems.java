package de.alextom.mcLobby.items;

import de.alextom.mcLobby.MCLobby;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Objects;

public class JoinItems {
    public static void giveJoinItems(Player player){
        player.getInventory().clear();
        if(MCLobby.getInstance().getConfig().getBoolean("Items.Navigator.Enable")){
            player.getInventory().setItem(MCLobby.getInstance().getConfig().getInt("Items.Navigator.PlaceInHotbar"),
                    ItemManager.createItem(Material.getMaterial(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Items.Navigator.Material"))),
                            MCLobby.getInstance().getConfig().getString("Items.Navigator.Name")));
        }
        if(MCLobby.getInstance().getConfig().getBoolean("Items.Utils.Enable")){
            player.getInventory().setItem(MCLobby.getInstance().getConfig().getInt("Items.Utils.PlaceInHotbar"),
                    ItemManager.createItem(Material.getMaterial(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Items.Utils.Material"))),
                            MCLobby.getInstance().getConfig().getString("Items.Utils.Name")));
        }
        if(MCLobby.getInstance().getConfig().getBoolean("Items.Settings.Enable")){
            player.getInventory().setItem(MCLobby.getInstance().getConfig().getInt("Items.Settings.PlaceInHotbar"),
                    ItemManager.createItem(Material.getMaterial(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Items.Settings.Material"))),
                            MCLobby.getInstance().getConfig().getString("Items.Settings.Name")));
        }
    }
}
