package com.practice.designpattern.behavioral.state.good.tools;

public class Eraser implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Eraser Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Erase something");
    }

}
