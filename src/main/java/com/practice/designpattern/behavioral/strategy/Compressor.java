package com.practice.designpattern.behavioral.strategy;

public interface Compressor {
    void compress(String fileName);
}

class JpegCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing to JPEG Image");
    }
}

class PngCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing to PNG Image");
    }
}
