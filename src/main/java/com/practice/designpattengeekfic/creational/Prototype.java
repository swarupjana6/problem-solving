package com.practice.designpattengeekfic.creational;

import lombok.Getter;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

public class Prototype {

    public static void main(String[] args) {
        new Prototype().call();
    }

    private void call() {
        List<Vehicle> vehicles = List.of(
                new Bike("bike_brand", "bike_model", "bike_color", 300),
                new Bus("bus_brand", "bus_model", "bus_color", 8)
        );

        vehicles.stream().map(vehicle -> vehicle.clone()).forEach(System.out::println);
    }
}

@Getter
@ToString
abstract class Vehicle implements Cloneable {

    private final String brand;
    private final String model;
    private final String color;

    public Vehicle(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    protected Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
    }

    @Override
    public abstract Vehicle clone();
}

@ToString(callSuper = true)
class Bike extends Vehicle {

    private final int topSpeed;

    public Bike(String brand, String model, String color, int topSpeed) {
        super(brand, model, color);
        this.topSpeed = topSpeed;
    }

    private Bike(Bike bike) {
        super(bike);
        this.topSpeed = bike.topSpeed;
    }

    @Override
    public Bike clone() {
        return new Bike(this);
    }
}

@ToString(callSuper = true)
class Bus extends Vehicle {

    private final int doors;

    public Bus(String brand, String model, String color, int doors) {
        super(brand, model, color);
        this.doors = doors;
    }

    private Bus(Bus bus) {
        super(bus);
        this.doors = bus.doors;
    }

    @Override
    public Bus clone() {
        return new Bus(this);
    }
}
