package com.practice.problems.adityaverma.dynamicprog.knapsack;

public class PrintDPMatrix {

    public static void printMatrix(int[] numbers, int index, boolean[][] results, int expectSum) {
        System.out.print("#" + "\t|\t");
        System.out.print("0" + "\t\t");
        for (int i = 1; i <= expectSum; i++) System.out.print(i + "\t\t");
        System.out.println();
        for (int i = 1; i <= expectSum; i++) System.out.print(" - - - - ");
        System.out.println();
        for (int i = 0; i <= index; i++) {
            System.out.print((i != 0 ? numbers[i - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int j = 0; j <= expectSum; j++) System.out.print(printChar(results[i][j]) + "\t");
            System.out.println();
        }
    }

    public static void printMatrix(int[] numbers, int index, int[][] results, int expectSum) {
        System.out.print("i\\j" + "\t|\t");
        System.out.print("0" + "\t\t");
        for (int i = 1; i <= expectSum; i++) System.out.print(i + "\t\t");
        System.out.println();
        for (int i = 0; i <= expectSum; i++) System.out.print(" - - - - ");
        System.out.println();
        for (int i = 0; i <= index; i++) {
            System.out.print((i != 0 ? numbers[i - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int j = 0; j <= expectSum; j++) System.out.print(printChar(results[i][j]) + "\t\t");
            System.out.println();
        }
    }

    public static void printMatrix(int[] weights, int[] values, int index, int[][] results, int expectSum) {
        System.out.print("(v-w)i\\j" + "\t|\t");
        System.out.print("0" + "\t\t");
        for (int i = 1; i <= expectSum; i++) System.out.print(i + "\t\t");
        System.out.println();
        for (int i = 0; i <= expectSum; i++) System.out.print(" - - - - ");
        System.out.println();
        for (int i = 0; i <= index; i++) {
            System.out.print((i != 0 ? values[i - 1] + " - " + weights[i - 1] + "\t\t|\t" : "0 - 0\t\t|\t"));
            for (int j = 0; j <= expectSum; j++) System.out.print(printChar(results[i][j]) + "\t\t");
            System.out.println();
        }
    }

    public static void printMatrix(char[] first, char[] second, int[][] results) {
        System.out.print("#" + "\t|\t");
        System.out.print("0" + "\t\t");
        for (int i = 1; i <= second.length; i++) System.out.print(second[i - 1] + "\t\t");
        System.out.println();
        for (int i = 1; i <= second.length; i++) System.out.print(" - - - - ");
        System.out.println();
        for (int i = 0; i <= first.length; i++) {
            System.out.print((i != 0 ? first[i - 1] + "\t|\t" : "(0)#" + "|\t"));
            for (int j = 0; j <= second.length; j++) System.out.print(printChar(results[i][j]) + "\t\t");
            System.out.println();
        }
    }

    public static String printChar(Object value) {
        if (value instanceof Boolean val) return val ? "1\t" : "-\t";
        else return value.toString();
    }
}