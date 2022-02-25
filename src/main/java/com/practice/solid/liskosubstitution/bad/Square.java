package com.practice.solid.liskosubstitution.bad;

public class Square extends Rectangle {

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setBreadth(length);
    }

    @Override
    public void setBreadth(double breadth) {
        super.setLength(breadth);
        super.setBreadth(breadth);
    }
}