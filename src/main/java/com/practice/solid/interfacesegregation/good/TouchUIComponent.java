package com.practice.solid.interfacesegregation.good;

public interface TouchUIComponent extends UICOmponent {

    public void touch(String event);
    public void swipe(String event);

}
