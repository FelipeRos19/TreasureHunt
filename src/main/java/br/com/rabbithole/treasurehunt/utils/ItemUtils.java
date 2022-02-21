package br.com.rabbithole.treasurehunt.utils;

import dev.gump.mars.Mars;
import org.bukkit.inventory.ItemStack;

public class ItemUtils {
    public static ItemStack createTreasure() {
        return Mars.items.createSkullByURL("https://textures.minecraft.net/texture/e34a592a79397a8df3997c43091694fc2fb76c883a76cce89f0227e5c9f1dfe", "&6Troféu");
    }
}
