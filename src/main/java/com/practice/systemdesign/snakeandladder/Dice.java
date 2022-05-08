package com.practice.systemdesign.snakeandladder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.IntStream;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Dice {

    private int numberOfDice;

    int rollDice() {
        return IntStream.rangeClosed(1, numberOfDice).map(num -> diceValue()).sum();
    }

    private int diceValue() {
        double rand = Math.random();
        return (rand < 0.1) ? 1 : (int) ((rand % 0.7) * 10);
    }
}
