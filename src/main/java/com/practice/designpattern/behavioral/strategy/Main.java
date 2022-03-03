package com.practice.designpattern.behavioral.strategy;

public class Main {

    public static void main(String[] args) {
        var imageStorage = new ImageStorage();
        imageStorage.store("a", new PngCompressor(), new BlackAndWhite());
        imageStorage.store("a", new JpegCompressor(), new BlackAndWhite());
    }
}
