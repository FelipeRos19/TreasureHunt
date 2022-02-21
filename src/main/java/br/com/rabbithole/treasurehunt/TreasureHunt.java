package br.com.rabbithole.treasurehunt;

import br.com.rabbithole.treasurehunt.commands.GiveCommand;
import br.com.rabbithole.treasurehunt.data.WormConfiguration;
import br.com.rabbithole.treasurehunt.data.tables.TreasureTable;
import br.com.rabbithole.treasurehunt.events.BlockPlace;
import br.com.rabbithole.treasurehunt.events.PlayerInteract;
import br.com.rabbithole.treasurehunt.utils.StringUtils;
import dev.gump.mars.Intent;
import dev.gump.mars.Mars;
import dev.gump.worm.Worm;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TreasureHunt extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("&a[TreasureHunt] iniciado com Sucesso!"));
        registers();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registers() {
        new GiveCommand(this);
        new BlockPlace(this);
        new PlayerInteract(this);
        Mars.init(getInstance(), Intent.ALL);
        Worm.getRegistry().registerTable("Treasure", TreasureTable.class);
        WormConfiguration.init();
    }

    public static TreasureHunt getInstance() {
        return TreasureHunt.getPlugin(TreasureHunt.class);
    }
}
