package com.practice.solid.interfacesegregation.good.components;

public interface TouchUIComponent extends UICOmponent {

    public void touch(String event);

    public void swipe(String event);

}
