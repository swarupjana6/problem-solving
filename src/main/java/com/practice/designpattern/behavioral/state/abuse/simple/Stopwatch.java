package com.practice.designpattern.behavioral.state.abuse.simple;

public class Stopwatch {

    private boolean isRunning;

    //Since the logic for Stopwatch is not going to change
    // hence it is not required to unnecessarily add complexity
    public void click() {
        if(isRunning) {
            isRunning = false;
            System.out.println("Stopped");
        } else {
            isRunning = true;
            System.out.println("Running");
        }
    }
}
