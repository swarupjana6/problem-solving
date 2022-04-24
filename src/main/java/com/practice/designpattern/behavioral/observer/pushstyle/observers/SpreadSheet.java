package com.practice.designpattern.behavioral.observer.pushstyle.observers;

import com.practice.designpattern.behavioral.observer.pushstyle.Observer;

public class SpreadSheet implements Observer {
    @Override
    public void update(int value) {
        System.out.format("SpreadSheet got updated : %d\n", value);
    }
}
