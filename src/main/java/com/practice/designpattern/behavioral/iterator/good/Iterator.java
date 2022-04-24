package com.practice.designpattern.behavioral.iterator.good;

public interface Iterator<T> {

    boolean hasNext();

    T current();

    void next();
}
