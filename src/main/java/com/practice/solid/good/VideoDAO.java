package com.practice.solid.good;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.practice.solid.good.Database.getConnection;

public class VideoDAO {

    public void persist(Video video) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String sql = " INSERT INTO video (title, time, likes, views) VALUES (" + video.getTitle() + "," + video.getTime() + "," + video.getLikes() + "," + video.getViews() + ")";
        stmt.executeUpdate(sql);
    }
}
