package com.practice.systemdesign.snakeandladder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Snake {
    private int head;
    @EqualsAndHashCode.Exclude
    private int tail;
}
