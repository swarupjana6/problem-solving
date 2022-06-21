package com.practice.solid.good;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/youtube";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
}
