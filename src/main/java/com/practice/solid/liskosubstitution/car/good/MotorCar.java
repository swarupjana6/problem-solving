package com.practice.solid.liskosubstitution.car.good;

public class MotorCar implements Car, EngineCar {

    private Engine engine;

    @Override
    public void turnOnEngine() {
        engine.on();
    }

    @Override
    public void accelerate() {
        engine.powerOn(1000);
    }
}