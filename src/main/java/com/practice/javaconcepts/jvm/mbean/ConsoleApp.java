package com.practice.javaconcepts.jvm.mbean;

import java.util.Scanner;

public class ConsoleApp {

    public static void startConsoleApp(Calculator calculator) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------");
            double firstNumber = Double.parseDouble(getUserInput(scanner, "enter first number"));
            double secondNumber = Double.parseDouble(getUserInput(scanner, "enter second number"));

            double sum = calculator.add(firstNumber, secondNumber);
            System.out.printf("sum = %s (rounded to %s decimal places)%n", sum, calculator.getDecimalPlaces());
        }
    }

    public static String getUserInput(Scanner scanner, String label) {
        System.out.print(label + ">");
        String userInput = scanner.nextLine();
        if ("exit".equals(userInput)) System.exit(0);
        return userInput;
    }
}
