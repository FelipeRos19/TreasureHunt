package br.com.rabbithole.treasurehunt.events;

import br.com.rabbithole.treasurehunt.TreasureHunt;
import br.com.rabbithole.treasurehunt.data.tables.TreasureTable;
import br.com.rabbithole.treasurehunt.utils.ItemUtils;
import br.com.rabbithole.treasurehunt.utils.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class BlockPlace implements Listener {

    final TreasureHunt plugin;

    public BlockPlace(TreasureHunt plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        ItemStack treasureItem = ItemUtils.createTreasure();
        ItemStack itemHand = event.getPlayer().getItemInHand();

        if(itemHand.isSimilar(treasureItem)) {
            TreasureTable treasure = new TreasureTable(
                    UUID.randomUUID().toString(),
                    event.getBlock().getWorld().getName(),
                    event.getBlock().getX(),
                    event.getBlock().getY(),
                    event.getBlock().getZ()
            );
            if(treasure.insert()) {
                event.getPlayer().sendMessage(StringUtils.format("&aTesouro colocado com Sucesso!"));
            }
            treasure.close();
        }
    }
}
