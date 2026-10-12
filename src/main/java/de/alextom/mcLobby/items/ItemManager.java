package de.alextom.mcLobby.items;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public static ItemStack createItem(Material material, String itemName){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(LegacyComponentSerializer.legacySection().deserialize(itemName));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
