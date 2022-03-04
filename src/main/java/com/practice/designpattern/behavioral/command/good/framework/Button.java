package com.practice.designpattern.behavioral.command.good.framework;

import lombok.Getter;
import lombok.Setter;

public class Button {

    @Getter @Setter
    private String label;

    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    // The code that should be executed here will be dependent on
    // where we use this button
    // Save to DB
    // Delete the record
    // At the time of designing the framework we do not know what the click will do
    // Command pattern will address this issue
    public void click() {
        command.execute();
    }
}
