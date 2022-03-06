package com.practice.solid.liskosubstitution;

public class SquareTest {

    public static void testSquare() {
        com.practice.solid.liskosubstitution.immutablerect.good.Rectangle r = new com.practice.solid.liskosubstitution.immutablerect.good.Square(5);
        assert (25 == (r.getLength() * r.getBreadth()));
    }

    public static void main(String[] args) {
        testSquare();
    }
}