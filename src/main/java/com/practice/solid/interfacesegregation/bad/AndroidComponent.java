package com.practice.solid.interfacesegregation.bad;

public class AndroidComponent implements Component {

    @Override
    public void mouseover(String event) {
        throw new UnsupportedOperationException("mouse click not supported");
    }

    @Override
    public void touch(String event) {
        System.out.println("Touch Event Fired");
    }

    @Override
    public void swipe(String event) {
        System.out.println("Swipe Event Fired");
    }

    @Override
    public void validate() {
        System.out.println("All UI is valid");
    }

}