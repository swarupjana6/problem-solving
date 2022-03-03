package com.practice.designpattern.behavioral.state;

import com.practice.designpattern.behavioral.state.bad.ToolType;

public class Main {

    public static void main(String[] args) {
        badWay();
        goodWay();
    }

    private static void goodWay() {
        var canvas = new Canvas();

        canvas.setCurrentTool(new Selection());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new Brush());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new Eraser());
        canvas.mouseDown();
        canvas.mouseUp();
    }

    private static void badWay() {
        var canvas = new com.practice.designpattern.behavioral.state.bad.Canvas();

        canvas.setCurrentTool(ToolType.SELECTION);
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(ToolType.BRUSH);
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(ToolType.ERASER);
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
