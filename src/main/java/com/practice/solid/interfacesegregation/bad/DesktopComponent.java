package com.practice.solid.interfacesegregation.bad;

public class DesktopComponent implements Component {

    @Override
    public void mouseover(String event) {
        System.out.println("Mouse click Event Fired");
    }

    @Override
    public void touch(String event) {
        throw new UnsupportedOperationException("touch not supported");
    }

    @Override
    public void swipe(String event) {
        throw new UnsupportedOperationException("swipe not supported");
    }

    @Override
    public void validate() {
        System.out.println("All UI is valid");
    }
}
