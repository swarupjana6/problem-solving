package com.practice.solid.liskosubstitution.car.good;

public class ElectricCar implements Car, EngineCar {

    @Override
    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    @Override
    public void accelerate() {
    }
}