package com.practice.problems.adityaverma.stack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static com.practice.problems.adityaverma.stack.MaximumAreaHistogram.histogramArea;

@Log4j2
public class MaximumAreaOfRectangle {

    public static void main(String[] args) {
        int[][] input = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        log.info(maxAreaOfRectangle(input));
    }

    private static Integer maxAreaOfRectangle(int[][] input) {
        // Approach : Convert 2D histogram to 1D and calculate the area

        // Step 1 : Get 1D Histogram
        Integer[] histogram1D = new Integer[input.length];
        for (int i = 0; i < input.length; i++) histogram1D[i] = input[0][i];

        // Step 2 : Get 1D Area of 1st Histogram
        int maximumHistogramArea = histogramArea(Arrays.asList(histogram1D));

        // Step 3 : Calculate are of subsequent 1D Histograms and add it to the previous 1D histogram
        for (int i = 1; i < input.length; i++) {
            // Make the histogram bar as zero if current element in 2D array is 0
            for (int j = 0; j < input.length; j++)
                histogram1D[j] = (input[i][j] == 0) ? 0 : histogram1D[j] + input[i][j];

            // Step 4 : Calculate are of the new Histogram
            maximumHistogramArea = Math.max(maximumHistogramArea, histogramArea(Arrays.asList(histogram1D)));
        }
        return maximumHistogramArea;
    }
}
