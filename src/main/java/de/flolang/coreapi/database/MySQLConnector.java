package de.flolang.coreapi.database;

import de.flolang.coreapi.bungee.CoreAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    private Connection con;
    private SQLException connectionError;

    public MySQLConnector(String HOST, String PORT, String DATABASE, String USERNAME, String PASSWORD) {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?autoReconnect=true", USERNAME, PASSWORD);
                System.out.println(CoreAPI.PREFIX + "§aMySQL connected!");
            } catch (SQLException e) {
                connectionError = e;
                System.out.println(CoreAPI.PREFIX + "§cMySQL error!");
            }
        }
    }

    public boolean isConnected() {
        return con != null;
    }

    public Connection getCon() {
        return con;
    }
}