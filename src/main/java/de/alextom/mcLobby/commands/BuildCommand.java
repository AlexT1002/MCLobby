package de.alextom.mcLobby.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import de.alextom.mcLobby.MCLobby;
import de.alextom.mcLobby.utils.BuildSystem;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class BuildCommand {
    public static LiteralCommandNode<CommandSourceStack> newCommand(final String commandName){
        return Commands.literal(commandName)
                .requires(source -> source.getSender().hasPermission("MCLobby.Build")
                && source.getSender()instanceof Player)
                .executes(context -> {
                    final CommandSender commandSender = context.getSource().getSender();

                    BuildSystem.changePlayerBuildmode((Player) commandSender);
                    if(BuildSystem.isPlayerInBuildmode((Player) commandSender)){
                        Component component = LegacyComponentSerializer.legacySection().deserialize(MCLobby.getPrefix() + Objects.requireNonNull(MCLobby.getMessageConfig().getString("BuildEnableMessage")));
                        commandSender.sendMessage(component);
                    }else{
                        Component component = LegacyComponentSerializer.legacySection().deserialize(MCLobby.getPrefix() + Objects.requireNonNull(MCLobby.getMessageConfig().getString("BuildDisableMessage")));
                        commandSender.sendMessage(component);
                    }
                    return Command.SINGLE_SUCCESS;
                }).build();
    }
}
