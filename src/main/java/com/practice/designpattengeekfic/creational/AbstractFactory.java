package com.practice.designpattengeekfic.creational;

public class AbstractFactory {

    public static void main(String[] args) {
        AbstractFactory factory = new AbstractFactory();
        factory.call();
    }

    private void call() {
        Company msi = new MsiManufacturer();
        msi.createGpu();
        msi.createMonitor();

        Company asus = new AsusManufacturer();
        asus.createGpu();
        asus.createMonitor();
    }
}

abstract class Company {

    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();
}

class MsiManufacturer extends Company {
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

class AsusManufacturer extends Company {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}

interface Gpu {
    void assemble();
}

interface Monitor {
    void assemble();
}

class MsiGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("MsiGpu assembled!!!");
    }
}

class AsusGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("AsusGpu assembled!!!");
    }
}

class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("MsiMonitor assembled!!!");
    }
}

class AsusMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("AsusMonitor assembled!!!");
    }
}