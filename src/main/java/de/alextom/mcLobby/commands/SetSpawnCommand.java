package de.alextom.mcLobby.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import de.alextom.mcLobby.MCLobby;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand {
    public static LiteralCommandNode<CommandSourceStack> newCommand(final String commandName){
        return Commands.literal(commandName)
                .requires(source ->
                        source.getSender().hasPermission("MCLobby.Spawn")
                        && source.getSender() instanceof Player)
                .executes(context -> {
                    final CommandSender commandSender = context.getSource().getSender();
                    final Player player = (Player) commandSender;
                    final Location location = player.getLocation();

                    MCLobby.getInstance().getConfig().set("Spawnlocation.x", location.getX());
                    MCLobby.getInstance().getConfig().set("Spawnlocation.y", location.getY());
                    MCLobby.getInstance().getConfig().set("Spawnlocation.z", location.getZ());
                    MCLobby.getInstance().getConfig().set("Spawnlocation.yaw", location.getYaw());
                    MCLobby.getInstance().getConfig().set("Spawnlocation.pitch", location.getPitch());
                    MCLobby.getInstance().getConfig().set("Spawnlocation.World", location.getWorld().getName());

                    MCLobby.getInstance().saveConfig();

                    commandSender.sendPlainMessage("Spawn wurde gesetzt!");
                    return Command.SINGLE_SUCCESS;
                }).build();
    }
}
