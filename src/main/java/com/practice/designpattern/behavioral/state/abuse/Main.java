package com.practice.designpattern.behavioral.state.abuse;

import com.practice.designpattern.behavioral.state.abuse.simple.Stopwatch;

public class Main {

    public static void main(String[] args) {
        System.out.println("Simple Stopwatch!!!!!!!");
        var stopwatch = new com.practice.designpattern.behavioral.state.abuse.simple.Stopwatch();
        stopwatch.click();
        stopwatch.click();
        stopwatch.click();

        System.out.println("DO NOT DO THIS >>>>> Stopwatch Abused!!!!!!!");
        var stopwatchAbused = new com.practice.designpattern.behavioral.state.abuse.complicated.Stopwatch();
        stopwatchAbused.click();
        stopwatchAbused.click();
        stopwatchAbused.click();
    }
}
