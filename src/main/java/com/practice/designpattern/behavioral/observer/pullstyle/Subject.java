package com.practice.designpattern.behavioral.observer.pullstyle;

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

    void notifyObservers() {
        observers.stream().forEach(Observer::update);
    }
}
