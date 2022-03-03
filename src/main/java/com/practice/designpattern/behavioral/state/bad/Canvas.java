package com.practice.designpattern.behavioral.state.bad;

import lombok.Getter;
import lombok.Setter;

public class Canvas {

    @Getter @Setter
    private ToolType currentTool;

    public void mouseDown() {
        if(currentTool == ToolType.SELECTION) {
            System.out.println("Selection Icon");
        } else if(currentTool == ToolType.ERASER) {
            System.out.println("Eraser Icon");
        } else if(currentTool == ToolType.BRUSH) {
            System.out.println("Brush Icon");
        }
    }

    public void mouseUp() {
        if(currentTool == ToolType.SELECTION) {
            System.out.println("Selection Icon");
        } else if(currentTool == ToolType.ERASER) {
            System.out.println("Eraser Icon");
        } else if(currentTool == ToolType.BRUSH) {
            System.out.println("Brush Icon");
        }
    }
}