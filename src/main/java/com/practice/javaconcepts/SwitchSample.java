package com.practice.javaconcepts;

public class SwitchSample {

    public static void main(String[] args) {
        oldSwitch("rohit");
        newSwitch("kohli");
    }

    public static void oldSwitch(String players) {
        switch (players) {
            case "kohli" :
                System.out.println("IND");
                break;
            case "rohit" :
                System.out.println("IND");
                break;
            case "starc" :
                System.out.println("AUS");
                break;
            case "rashid" :
                System.out.println("AFG");
                break;
            default:
                System.out.println("I don't know the player");
        }
    }

    // as of java 17
    public static void newSwitch(String players) {
        switch (players) {
            case "kohli" , "rohit" -> System.out.println("IND");
            case "starc" -> System.out.println("AUS");
            case "rashid" -> System.out.println("AFG");
            default -> System.out.println("I don't know the player");
        }
    }
}
