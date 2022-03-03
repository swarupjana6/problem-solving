package com.practice.designpattern.behavioral.state;

public interface Tool {

    void mouseDown();

    void mouseUp();
}

class Brush implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Brush Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line");
    }

}

class Eraser implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Eraser Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Erase something");
    }

}

class Selection implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("Selection Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw dashed rectangle");
    }

}

