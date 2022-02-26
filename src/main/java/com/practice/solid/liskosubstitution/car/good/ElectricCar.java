package com.practice.solid.liskosubstitution.car.good;

public class ElectricCar implements Car , ElectricCarStarter {

    private ElectricMotor electricMotor;

    @Override
    public void accelerate() {
        System.out.println("Accelerating electric car!!");
    }

    @Override
    public void turnOnElectricMotor() {
        electricMotor.switchOnMotor();
    }
}