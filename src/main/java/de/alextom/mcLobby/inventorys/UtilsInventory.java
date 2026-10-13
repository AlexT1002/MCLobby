package de.alextom.mcLobby.inventorys;

import de.alextom.mcLobby.MCLobby;
import de.alextom.mcLobby.items.ItemManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilsInventory implements InventoryHolder {
    private final Inventory inventory;
    private Map<ItemStack, String> utilsItemsCommands = new HashMap<>();

    public UtilsInventory(MCLobby instance){
        String title = instance.getConfig().getString("Inventory.Utils.Title");
        assert title != null;
        Component component = LegacyComponentSerializer.legacySection().deserialize(title);
        int size = instance.getConfig().getInt("Inventory.Utils.Size");

        this.inventory = instance.getServer().createInventory(this, size, component);
        ConfigurationSection configurationSection = instance.getConfig().getConfigurationSection("Inventory.Utils.Slots");
        if(configurationSection != null){
            for(String key : configurationSection.getKeys(false)){
                int slot = Integer.parseInt(key);
                String name = configurationSection.getString(key+".Name");
                String lore = configurationSection.getString(key+".Lore");
                String material = configurationSection.getString(key+".Material");
                String command = configurationSection.getString(key+".Command");


                if(material != null){
                    if(lore != null && lore.isEmpty()){
                        ItemStack itemStack = ItemManager.createItem(Material.getMaterial(material), name);
                        utilsItemsCommands.put(itemStack, command);
                        this.inventory.setItem(slot, itemStack);
                    }else{
                        List<Component> loreList = new ArrayList<>();
                        assert lore != null;
                        String[] loreSplit = lore.split("<line>");
                        for(String lores : loreSplit){
                            Component loreComponent = LegacyComponentSerializer.legacySection().deserialize(lores);
                            loreList.add(loreComponent);
                        }

                        ItemStack itemStack = ItemManager.createItem(Material.getMaterial(material), name, loreList);
                        utilsItemsCommands.put(itemStack, command);
                        this.inventory.setItem(slot, itemStack);
                    }
                }
            }
        }
    }
    public void openInventory(Player player){
        player.openInventory(inventory);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public Map<ItemStack, String> getUtilsItemsCommands() {
        return utilsItemsCommands;
    }
}
