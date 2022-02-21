package br.com.rabbithole.treasurehunt.data.tables;

import dev.gump.worm.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TreasureTable extends WormTable {

    @WormField(sqlType = "VARCHAR", length = 36, primaryKey = true)
    private String uuid;

    @WormField(sqlType = "VARCHAR", length = 16, defaultValue = " NULL ")
    private String nick;

    @WormField(sqlType = "VARCHAR", length = 16)
    private String world;

    @WormField(sqlType = "INT")
    private double x;

    @WormField(sqlType = "INT")
    private double y;

    @WormField(sqlType = "INT")
    private double z;

    public TreasureTable() {
    }

    public TreasureTable(String uuid, String world, double x, double y, double z) {
        this.uuid = uuid;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static int getLength() {
        int length = 0;
        try {
            String sqlQuery = "SELECT COUNT(*) FROM Treasure where nick = ' NULL ';";
            WormQuery query = Worm.query(sqlQuery);
            ResultSet resultSet = query.getStatement().executeQuery();
            if(resultSet.next()) {
                length = resultSet.getInt(1);
            }
            query.getConnection().close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return length;
    }
}
