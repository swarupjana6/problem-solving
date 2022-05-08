package com.practice.systemdesign.SnakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Ladder {
    @EqualsAndHashCode.Exclude
    private int top;
    private int bottom;
}
