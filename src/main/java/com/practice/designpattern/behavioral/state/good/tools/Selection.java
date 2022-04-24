package com.practice.designpattern.behavioral.state.good.tools;

public class Selection implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Selection Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw dashed rectangle");
    }

}
