package br.com.rabbithole.treasurehunt.utils;

import net.md_5.bungee.api.ChatColor;

public class StringUtils {
    public static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String strip(String msg) {
        return ChatColor.stripColor(msg);
    }
}
