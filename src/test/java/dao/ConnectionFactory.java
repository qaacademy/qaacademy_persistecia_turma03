package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String serverName = "192.168.18.6";
        String portNumber = "1521";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
        String username = "system";
        String password = "qaacademy";
        return DriverManager.getConnection(url, username, password);
    }
}
