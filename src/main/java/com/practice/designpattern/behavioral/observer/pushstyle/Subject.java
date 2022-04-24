package com.practice.designpattern.behavioral.observer.pushstyle;

import java.util.ArrayList;
import java.util.List;

//Observable
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    void notifyObservers(int value) {
        observers.stream().forEach(observer -> observer.update(value));
    }
}
