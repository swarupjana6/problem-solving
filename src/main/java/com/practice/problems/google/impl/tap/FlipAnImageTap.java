package com.practice.problems.google.impl.tap;

import com.practice.problems.google.FlipAnImage;

public class FlipAnImageTap extends FlipAnImage {
    @Override
    protected int[][] flipImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int j = 0;
            int k = image[i].length - 1;
            while (j < k) {
                image[i][j] = image[i][j] + image[i][k];
                image[i][k] = image[i][j] - image[i][k];
                image[i][j] = image[i][j] - image[i][k];
                j++;
                k--;
            }

            for(j = 0; j < image[i].length; j++) image[i][j] = image[i][j] == 1 ? 0 : 1;
        }

        return image;
    }
}
