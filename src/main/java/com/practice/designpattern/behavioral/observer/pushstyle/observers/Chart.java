package com.practice.designpattern.behavioral.observer.pushstyle.observers;

import com.practice.designpattern.behavioral.observer.pushstyle.Observer;

public class Chart implements Observer {
    @Override
    public void update(int value) {
        System.out.format("Chart got updated : %d\n", value);
    }
}
