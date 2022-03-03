package com.practice.designpattern.behavioral.strategy;

public class ImageStorage {

    public void store(String fileName, Compressor compressor, Filter filter) {
        // Step 1: Image compression algo
        // Step 2: Black and white filter, high contrast filter
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
