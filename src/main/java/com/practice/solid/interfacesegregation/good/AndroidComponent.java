package com.practice.solid.interfacesegregation.good;

import com.practice.solid.interfacesegregation.good.components.TouchUIComponent;

public class AndroidComponent implements TouchUIComponent {

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