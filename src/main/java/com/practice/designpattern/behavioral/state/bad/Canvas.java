package com.practice.designpattern.behavioral.state.bad;

import lombok.Getter;
import lombok.Setter;

public class Canvas {

    @Getter
    @Setter
    private ToolType currentTool;

    public void mouseDown() {
        switch (currentTool) {
            case SELECTION -> System.out.println("Selection Icon");
            case ERASER -> System.out.println("Eraser Icon");
            case BRUSH -> System.out.println("Brush Icon");
        }
    }

    public void mouseUp() {
        switch (currentTool) {
            case SELECTION -> System.out.println("Draw dashed rectangle");
            case ERASER -> System.out.println("Erase something");
            case BRUSH -> System.out.println("Draw a line");
        }
    }
}