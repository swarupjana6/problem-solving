package com.practice.solid.liskosubstitution.immutablerect.good;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Rectangle {

    @NonNull
    @Getter
    private double length;

    @NonNull
    @Getter
    private double breadth;

    public double area() {
        return length * breadth;
    }
}
