package com.practice.systemdesign.SnakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
class Player {
    private String playerName;
    private int id;
}
