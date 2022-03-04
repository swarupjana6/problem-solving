package com.practice.designpattern.behavioral.observer.pushstyle;

import lombok.Getter;

public class Datasource extends Subject {

    @Getter
    private Integer value;

    public void setValue(Integer value) {
        this.value = value;
        notifyObservers(value);
    }
}
