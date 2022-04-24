package com.practice.designpattern.behavioral.state.good;

import com.practice.designpattern.behavioral.state.good.tools.Tool;
import lombok.Getter;
import lombok.Setter;

public class Canvas {

    @Getter
    @Setter
    private Tool currentTool;

    public void mouseDown() {
        currentTool.mouseDown();
    }

    public void mouseUp() {
        currentTool.mouseUp();
    }
}
