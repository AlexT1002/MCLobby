package de.alextom.mcLobby.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import de.alextom.mcLobby.MCLobby;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SpawnCommand {
    public static LiteralCommandNode<CommandSourceStack> newCommand(final String commandName){
        return Commands.literal(commandName)
                .requires(source ->
                        source.getSender().hasPermission("MCLobby.Spawn")
                        && source.getSender() instanceof Player)
                .executes(context -> {
                   final CommandSender commandSender = context.getSource().getSender();
                   final Player player = (Player) commandSender;
                   final Location location = new Location(
                           Bukkit.getWorld(Objects.requireNonNull(MCLobby.getInstance().getConfig().getString("Spawnlocation.World"))),
                           MCLobby.getInstance().getConfig().getDouble("Spawnlocation.x"),
                           MCLobby.getInstance().getConfig().getDouble("Spawnlocation.y"),
                           MCLobby.getInstance().getConfig().getDouble("Spawnlocation.z"),
                           (float) MCLobby.getInstance().getConfig().getDouble("Spawnlocation.yaw"),
                           (float) MCLobby.getInstance().getConfig().getDouble("Spawnlocation.pitch")
                   );
                   player.teleport(location);
                   commandSender.sendPlainMessage("Du wurdest zum Spawn teleportiert!");

                   return Command.SINGLE_SUCCESS;
                }).build();
    }
}
