package com.practice.designpattern.behavioral.state;

import lombok.Getter;
import lombok.Setter;

public class Canvas {

    @Getter @Setter
    private Tool currentTool;

    public void mouseDown() {
        currentTool.mouseDown();
    }

    public void mouseUp() {
        currentTool.mouseUp();
    }
}
