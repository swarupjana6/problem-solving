package com.practice.designpattern.decorator;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorsViaFilters {

    public static void printIt(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        printIt(new Camera());
        printIt(new Camera(Color::brighter));
        printIt(new Camera(Color::darker));
        printIt(new Camera(Color::brighter, Color::darker));
    }
}

class Camera {

    private Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters) {
        /** 1st way **/
        //filter = input -> input;
        //for (Function<Color, Color> aFilter : filters) filter = filter.andThen(aFilter);

        /** 2nd way **/
        //filter = Stream.of(filters).reduce(input -> input, (aFilter, result) -> result.andThen(aFilter));
        filter = Stream.of(filters).reduce(Function.identity(), Function::andThen);
    }

    public Color snap(Color input) {
        return filter.apply(input);
    }
}
