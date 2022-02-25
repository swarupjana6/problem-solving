package com.practice.solid.singleresponsibility.good;

public class Printer {

    public void printToConsole(Printable printable) {
        System.out.println(printable.getContent());
    }

}