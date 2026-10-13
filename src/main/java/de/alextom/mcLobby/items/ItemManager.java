package de.alextom.mcLobby.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemManager {
    public static ItemStack createItem(Material material, String itemName, List<Component> lore){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(LegacyComponentSerializer.legacySection().deserialize(itemName));
        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
    public static ItemStack createItem(Material material, String itemName){
        return createItem(material, itemName, null);
    }
}
