package br.com.rabbithole.treasurehunt.events;

import br.com.rabbithole.treasurehunt.TreasureHunt;
import br.com.rabbithole.treasurehunt.data.tables.TreasureTable;
import br.com.rabbithole.treasurehunt.utils.FireworkUtils;
import br.com.rabbithole.treasurehunt.utils.StringUtils;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

    final TreasureHunt plugin;

    public PlayerInteract(TreasureHunt plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Block block = event.getClickedBlock();
            if(block != null) {
                if(block.getBlockData().getMaterial().equals(Material.PLAYER_HEAD)) {
                    Location location = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ());
                    Location playerLocation = event.getPlayer().getLocation();
                    TreasureTable treasure = new TreasureTable();
                    treasure.setWorld(location.getWorld().getName());
                    treasure.setX(location.getX());
                    treasure.setY(location.getY());
                    treasure.setZ(location.getZ());
                    treasure.findWhere("world = '"+treasure.getWorld()+"' and x ="+treasure.getX()+" and y = "+treasure.getY()+" and z = "+treasure.getZ());
                    if(treasure.next()) {
                        treasure.setNick(event.getPlayer().getName());
                        if(treasure.update()) {
                            //Bukkit.getServer().broadcast(new TextComponent(StringUtils.format("&aO Jogador &6"+event.getPlayer().getName()+"&a encontrou um Tesouro!")));
                            Bukkit.getServer().broadcast(new TextComponent(StringUtils.format("&aO Jogador &6"+event.getPlayer().getName()+"&a chegou ao Final!")));
                            Bukkit.getServer().broadcast(new TextComponent(StringUtils.format("&aRestam: &6"+TreasureTable.getLength()+"&a Vagas!")));
                            //FireworkUtils.spawnFireworks(playerLocation, 2);
                            block.setType(Material.AIR);
                        }
                        treasure.close();
                    }
                }
            }
        }
    }
}
