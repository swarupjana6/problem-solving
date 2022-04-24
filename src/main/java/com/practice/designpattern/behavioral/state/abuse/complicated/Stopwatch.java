package com.practice.designpattern.behavioral.state.abuse.complicated;

import lombok.Getter;
import lombok.Setter;

public class Stopwatch {

    @Getter
    @Setter
    private State currentState = new StoppedState(this);

    public void click() {
        currentState.click();
    }
}

interface State {
    void click();
}

class StoppedState implements State {

    private Stopwatch stopwatch;

    StoppedState(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setCurrentState(new RunningState(stopwatch));
        System.out.println("Running");
    }
}

class RunningState implements State {

    private Stopwatch stopwatch;

    RunningState(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setCurrentState(new StoppedState(stopwatch));
        System.out.println("Stopped");
    }
}