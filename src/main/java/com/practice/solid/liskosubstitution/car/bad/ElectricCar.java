package com.practice.solid.liskosubstitution.car.bad;

public class ElectricCar implements Car {

    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    public void accelerate() {
    }
}