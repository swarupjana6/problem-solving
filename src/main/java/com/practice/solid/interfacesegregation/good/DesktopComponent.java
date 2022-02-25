package com.practice.solid.interfacesegregation.good;

import com.practice.solid.interfacesegregation.good.components.NonTouchUIComponent;

public class DesktopComponent implements NonTouchUIComponent {

    @Override
    public void mouseover(String event) {
        System.out.println("Mouse click Event Fired");
    }

    @Override
    public void validate() {
        System.out.println("All UI is valid");
    }
}
