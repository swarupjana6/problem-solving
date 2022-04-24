package com.practice.designpattern.behavioral.strategy.bad;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageStorage {

    private String compressor;

    private String filter;

    public void store(String fileName) {
        // Step 1: Image compression algo
        // JPEG, PNG
        // Step 2: Black and white filter, high contrast filter

        if(compressor == "jpeg") {
            System.out.println("Compress using JPEG");
        } else if (compressor == "png") {
            System.out.println("Compress using PNG");
        }

        if(filter == "b&w") {
            System.out.println("Apply black and white filter");
        } else if(filter == "high-contrast") {
            System.out.println("apply high-contrast filter");
        }
    }
}
