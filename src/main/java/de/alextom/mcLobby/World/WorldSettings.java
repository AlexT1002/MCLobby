package de.alextom.mcLobby.World;

import de.alextom.mcLobby.MCLobby;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Objects;

public class WorldSettings {
    public static void mainWorldSettings(){
        World world = Bukkit.getWorld(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Spawnlocation.World")));
        if(world != null){
            world.setTime(2000);
        }
    }
}
