package com.practice.solid.liskosubstitution.good;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    public void testSquare() {
        Rectangle r = getRectangle();
        assertEquals(25, (r.getLength() * r.getBreadth()));
    }

    private Rectangle getRectangle() {
        return new Square(5);
    }
}