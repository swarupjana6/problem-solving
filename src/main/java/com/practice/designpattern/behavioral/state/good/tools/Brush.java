package com.practice.designpattern.behavioral.state.good.tools;

public class Brush implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Brush Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line");
    }

}
