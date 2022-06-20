package com.practice.designpattengeekfic.creational;

public class Factory {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.call();
    }

    private void call() {
        Burger veggieBurger = new VeggieBurgerRestaurant().orderBurger();
        Burger chickenBurger = new ChickenBurgerRestaurant().orderBurger();
    }
}

abstract class Restaurant {
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}

class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}

class ChickenBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
}

interface Burger {
    void prepare();
}

class VeggieBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Burger");
    }
}

class ChickenBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Burger");
    }
}