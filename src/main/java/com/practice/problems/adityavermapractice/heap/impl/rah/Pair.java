package com.practice.problems.adityavermapractice.heap.impl.rah;

public record Pair(Integer key, Integer value) implements Comparable<Pair> {

    @Override
    public int compareTo(Pair pair) {
        return this.key.compareTo(pair.key());
    }
}
