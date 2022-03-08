package com.practice.problems.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static com.practice.problems.stack.MaximumAreaHistogram.histogramArea;

public class MaximumAreaOfRectangle {

    static final Logger log = LogManager.getLogger(MaximumAreaOfRectangle.class);

    public static void main(String[] args) {
        int[][] input = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        System.out.println(maxAreaOfRectangle(input));
    }

    private static Integer maxAreaOfRectangle(int[][] input) {
        Integer[] vec = new Integer[input.length];
        int cnt = 0;
        for (int i = 0; i < input.length; i++) vec[i] = input[i][cnt++];

        int mah = histogramArea(Arrays.asList(vec));

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] == 0) vec[j] = 0;
                else vec[j] = vec[j] + input[i][j];
            }
            mah = Math.max(mah, histogramArea(Arrays.asList(vec)));
        }
        return mah;
    }
}
