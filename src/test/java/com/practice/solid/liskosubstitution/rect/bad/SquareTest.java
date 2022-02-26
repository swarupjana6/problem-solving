package com.practice.solid.liskosubstitution.rect.bad;

import com.practice.solid.liskosubstitution.rect.bad.Rectangle;
import com.practice.solid.liskosubstitution.rect.bad.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @Test
    public void testSquare() {
        Rectangle r = getRectangle();
        assertEquals(20, (r.getLength() * r.getBreadth()));
    }

    private Rectangle getRectangle() {
        Square square = new Square();
        square.setLength(5);
        square.setBreadth(4);
        return square;
    }
}