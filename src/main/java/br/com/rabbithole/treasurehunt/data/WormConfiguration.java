package br.com.rabbithole.treasurehunt.data;

import dev.gump.worm.Worm;
import dev.gump.worm.WormConnection;

public class WormConfiguration {
    public static void init() {
        WormConnection connection = new WormConnection("localhost", 3306, "root", "123456", "rabbithole");
        Worm.init(connection);
    }
}
