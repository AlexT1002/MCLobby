package de.alextom.mcLobby.items;

import de.alextom.mcLobby.MCLobby;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class JoinItems {
    private static ItemStack navigatorItem = ItemManager.createItem(Material.getMaterial(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Items.Navigator.Material"))), MCLobby.getInstance().getConfig().getString("Items.Navigator.Name"));
    private static ItemStack utilsItem = ItemManager.createItem(Material.getMaterial(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Items.Utils.Material"))), MCLobby.getInstance().getConfig().getString("Items.Utils.Name"));
    private static ItemStack settingsItem = ItemManager.createItem(Material.getMaterial(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Items.Settings.Material"))), MCLobby.getInstance().getConfig().getString("Items.Settings.Name"));

    public static void giveJoinItems(Player player){
        player.getInventory().clear();
        if(MCLobby.getInstance().getConfig().getBoolean("Items.Navigator.Enable")){
            player.getInventory().setItem(MCLobby.getInstance().getConfig().getInt("Items.Navigator.PlaceInHotbar"), navigatorItem);
        }
        if(MCLobby.getInstance().getConfig().getBoolean("Items.Utils.Enable")){
            player.getInventory().setItem(MCLobby.getInstance().getConfig().getInt("Items.Utils.PlaceInHotbar"), utilsItem);
        }
        if(MCLobby.getInstance().getConfig().getBoolean("Items.Settings.Enable")){
            player.getInventory().setItem(MCLobby.getInstance().getConfig().getInt("Items.Settings.PlaceInHotbar"), settingsItem);
        }
    }

    public static ItemStack getNavigatorItem() {
        return navigatorItem;
    }

    public static ItemStack getSettingsItem() {
        return settingsItem;
    }

    public static ItemStack getUtilsItem() {
        return utilsItem;
    }
}
