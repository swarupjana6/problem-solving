package com.practice.problems.adityaverma.heap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pair implements Comparable<Pair> {

    private Integer key;

    private Integer value;

    @Override
    public int compareTo(Pair compareWith) {
        return this.key.compareTo(compareWith.getKey());
    }

    @Override
    public String toString() {
        return "Pair{" + key + ',' + value + '}';
    }
}
