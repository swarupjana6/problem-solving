package com.practice.problems.adityaverma.dynamicprog.knapsack;

public class PrintDPMatrix {
    public static void printMatrix(int[] numbers, int index, boolean[][] results, int expectSum) {
        System.out.print("#" + "\t\t");
        System.out.print("0" + "\t\t");
        for (int i = 1; i <= expectSum; i++) System.out.print(i + "\t\t");
        System.out.println();
        for (int i = 0; i <= index; i++) {
            System.out.print((i != 0 ? numbers[i - 1] : "0") + "\t\t");
            for (int j = 0; j <= expectSum; j++) System.out.print(printChar(results[i][j]) + "\t");
            System.out.println();
        }
    }

    public static void printMatrix(int[] numbers, int index, int[][] results, int expectSum) {
        System.out.print("#" + "\t\t");
        System.out.print("0" + "\t\t");
        for (int i = 1; i <= expectSum; i++) System.out.print(i + "\t\t");
        System.out.println();
        for (int i = 0; i <= index; i++) {
            System.out.print((i != 0 ? numbers[i - 1] : "0") + "\t\t");
            for (int j = 0; j <= expectSum; j++) System.out.print(printChar(results[i][j]) + "\t\t");
            System.out.println();
        }
    }

    public static String printChar(Object value) {
        if (value instanceof Boolean val) return val ? "1\t" : "-\t";
        else return value.toString();
    }
}