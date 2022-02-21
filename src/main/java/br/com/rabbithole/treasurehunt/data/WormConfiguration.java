package br.com.rabbithole.treasurehunt.data;

import dev.gump.worm.Worm;
import dev.gump.worm.WormConnection;

public class WormConfiguration {
    public static void init() {
        WormConnection connection = new WormConnection("", 3306, "", "", "");
        Worm.init(connection);
    }
}
