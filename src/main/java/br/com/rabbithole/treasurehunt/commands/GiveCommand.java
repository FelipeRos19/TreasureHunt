package br.com.rabbithole.treasurehunt.commands;

import br.com.rabbithole.treasurehunt.TreasureHunt;
import br.com.rabbithole.treasurehunt.utils.ItemUtils;
import br.com.rabbithole.treasurehunt.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveCommand implements CommandExecutor {

    final TreasureHunt plugin;

    public GiveCommand(TreasureHunt plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("givetreasure").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(StringUtils.format("&cApenas jogadores podem executar este Comando!"));
        }
        Player player = (Player)sender;

        if(!player.isOp()) {
            player.sendMessage(StringUtils.format("&cVocê não tem permissão para executar este Comando!"));
        } else {
            player.getInventory().addItem(ItemUtils.createTreasure());
        }
        return false;
    }
}
