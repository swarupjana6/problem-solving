package com.practice.solid.bad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Video {

    private String title;
    private int time;
    private int views;
    private int likes;

    public double getNumberOfHoursPlayed() {
        return (time / 3600) * views;
    }

    public void persist() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/youtube";
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String sql = " INSERT INTO video (title, time, likes, views) VALUES (" + title + "," + time + "," + likes + "," + views + ")";
        stmt.executeUpdate(sql);
    }
}
