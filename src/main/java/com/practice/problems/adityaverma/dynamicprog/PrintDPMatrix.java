package com.practice.problems.adityaverma.dynamicprog;

import java.util.Map;
import java.util.stream.IntStream;

public class PrintDPMatrix {

    public static void printMatrix(int[] numbers, boolean[][] results, int expectSum) {
        int index = numbers.length;
        System.out.print("#" + "\t|\t");
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? X + "\t\t" : X + "\t\t\n"));
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? "======\t" : "======\t======\n"));
        for (int Y = 0; Y <= index; Y++) {
            System.out.print((Y != 0 ? numbers[Y - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int X = 0; X <= expectSum; X++) System.out.print(printChar(results[Y][X]) + "\t");
            System.out.println();
        }
    }

    public static void printMatrix(int[] numbers, int index, boolean[][] results, int expectSum) {
        System.out.print("#" + "\t|\t");
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? X + "\t\t" : X + "\t\t\n"));
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? "======\t" : "======\t======\n"));
        for (int Y = 0; Y <= index; Y++) {
            System.out.print((Y != 0 ? numbers[Y - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int X = 0; X <= expectSum; X++) System.out.print(printChar(results[Y][X]) + "\t");
            System.out.println();
        }
    }

    public static void printMatrix(int[] numbers, int index, int[][] results, int expectSum) {
        System.out.print("Y\\X" + "\t|\t");
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? X + "\t\t" : X + "\t\t\n"));
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? "======\t" : "======\t======\n"));
        for (int Y = 0; Y <= index; Y++) {
            System.out.print((Y != 0 ? numbers[Y - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int X = 0; X <= expectSum; X++) System.out.print(printChar(results[Y][X]) + "\t\t");
            System.out.println();
        }
    }

    public static void printMatrix(int[] weights, int[] values, int index, int[][] results, int expectSum) {
        System.out.print("(v-w)Y\\X" + "\t|\t");
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? X + "\t\t" : X + "\t\t\n"));
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? "======\t" : "======\t======\n"));
        for (int Y = 0; Y <= index; Y++) {
            System.out.print((Y != 0 ? values[Y - 1] + " - " + weights[Y - 1] + "\t\t|\t" : "0 - 0\t\t|\t"));
            for (int X = 0; X <= expectSum; X++) System.out.print(printChar(results[Y][X]) + "\t\t");
            System.out.println();
        }
    }

    public static void printMatrix(char[] first, char[] second, int[][] results) {
        System.out.print("Y\\X" + "\t|\t" + "0\t\t");
        IntStream.rangeClosed(1, second.length).forEach(X -> System.out.print(X != second.length ? second[(X - 1)] + "\t\t" : second[X - 1] + "\t\t\n"));
        IntStream.rangeClosed(0, second.length).forEach(X -> System.out.print(X != second.length ? "======\t" : "======\t======\n"));
        for (int Y = 0; Y <= first.length; Y++) {
            System.out.print((Y != 0 ? first[Y - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int X = 0; X <= second.length; X++) System.out.print(printChar(results[Y][X]) + "\t\t");
            System.out.println();
        }
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void printMatrix(int[] first, int[] second, int[][] results) {
        System.out.print("Y\\X" + "\t\t|\t" + "0\t\t\t");
        IntStream.rangeClosed(1, second.length).forEach(X -> System.out.print(X != second.length ? second[(X - 1)] + "\t\t\t" : second[X - 1] + "\t\t\t\n"));
        IntStream.rangeClosed(0, second.length).forEach(X -> System.out.print(X != second.length ? "======\t\t" : "======\t\t======\n"));
        for (int Y = 0; Y <= first.length; Y++) {
            System.out.print((Y != 0 ? first[Y - 1] + "\t\t|\t" : "(0)#" + "\t|\t"));
            for (int X = 0; X <= second.length; X++) System.out.print(printChar(results[Y][X]) + "\t\t\t");
            System.out.println();
        }
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public static String printChar(Object value) {
        if (value instanceof Boolean val) return val ? "1\t" : "-\t";
        else return value.toString();
    }

    public static void printMemoizedMap(int[] numbers, int index, Map<String, Integer> results, int expectSum) {
        System.out.print("Y\\X" + "\t|\t");
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? X + "\t\t" : X + "\t\t\n"));
        IntStream.rangeClosed(0, expectSum).forEach(X -> System.out.print(X != expectSum ? "======\t" : "======\t======\n"));

        int index1 = index;
        while (index1 > 0) {
            int Y = (index - index1);
            System.out.print((Y != 0 ? numbers[Y - 1] + "\t\t|\t" : "(0)#" + "\t|\t"));
            for (int i = 0; i <= expectSum; i++)
                System.out.print(results.get((index - index1) + "-" + i) + "\t\t");

            index1--;
            System.out.println("");
        }
    }
}