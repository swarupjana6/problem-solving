package com.practice.javaconcepts;

public class MeaningfulNullPointerExceptions {

    private record Person(String name, int age) {
    }

    public static void main(String[] args) {
        Person person1 = new Person("tom", 19);
        System.out.println(person1.name().toLowerCase());

        Person person2 = new Person(null, 19);;
        System.out.println(person2.name().toLowerCase());

        Person person3 = null;
        System.out.println(person3.name().toLowerCase());
    }
}
