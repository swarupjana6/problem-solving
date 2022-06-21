package com.practice.solid.good;

import lombok.Data;

@Data
public class Video {

    private String title;
    private int time;
    private int views;
    private int likes;

    public double getNumberOfHoursPlayed() {
        return (time / 3600) * views;
    }
}
