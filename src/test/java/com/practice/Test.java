package com.practice;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void main(String[] args) {
        int random = ThreadLocalRandom.current().nextInt(0, 10);
        System.out.println(random);
        //System.out.println(new Calculator2("(7)-(0)+(4)").calculate());
        //System.out.println(new Test().calculate("3+22*2"));
        //System.out.println(new Test().calculate("1 + 1"));
        //System.out.println(new Test().calculate(" 1 + 1"));
        //System.out.println(new Test().calculate("12-3*4"));
    }

    private static String blank(int space) {
        return new String(new char[space]).replace("\0", " ");
    }
}

class Calculator1 {

    private char[] arr;
    private int index = 0;

    public Calculator1(String s) {
        this.arr = s.toCharArray();
        this.index = 0;
    }
    private int calculate() {
        int sum = 0, operator = 1;

        while (index < arr.length) {

            if (arr[index] == ')') {
                break;
            } else if (arr[index] == '(') {
                index++;
                sum += operator * calculate();
            } else if (arr[index] == '-') {
                operator = -1;
            } else if (arr[index] == '+') {
                operator = 1;
            }
            else if (Character.isDigit(arr[index])) {

                StringBuilder number = new StringBuilder();
                while (index < arr.length && Character.isDigit(arr[index]))
                    number.append(arr[index++]);

                index--;
                sum += Integer.parseInt(number.toString()) * operator;
            }

            index++;
        }

        return sum;
    }

}

class Calculator2 {

    private char[] arr;
    private int index;

    public Calculator2(String s) {
        this.arr = s.toCharArray();
        this.index = 0;
    }

    public int calculate() {
        Stack<Integer> sums = new Stack<>();
        char operator = '+';

        while (index < arr.length) {
            if(Character.isDigit(arr[index])) {
                int number = getNumber();
                insertElement(sums, operator, number);
            } else if (arr[index] == '(') {
                index++;
                int number = calculate();
                insertElement(sums, operator, number);
            } else if (arr[index] == ')') {
                break;
            } else {
                operator = arr[index];
            }

            index++;
        }

        int sum = sums.stream().mapToInt(num -> num).sum();
        return sum;
    }

    private int getNumber() {
        StringBuilder numberStr = new StringBuilder();

        while (index < arr.length && Character.isDigit(arr[index]))
            numberStr.append(arr[index++]);

        index--;
        int number = Integer.parseInt(numberStr.toString());
        return number;
    }

    private void insertElement(Stack<Integer> sums, char operator, int number) {
        if(operator == '+') number = 1 * number;
        else if(operator == '-') number = -1 * number;
        else if(operator == '*') number = sums.pop() * number;
        else if(operator == '/') number = sums.pop() / number;

        sums.add(number);
    }
}
