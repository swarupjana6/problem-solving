package com.practice.solid.liskosubstitution.good;

public class Rectangle {

    private double length;

    private double breadth;

    public Rectangle(double length, double height) {
        this.length = length;
        this.breadth = height;
    }

    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    public double area() {
        return length * breadth;
    }
}
