package com.practice.javaconcepts.records;

public class PersonUsage {

    public static void main(String[] args) {
        // OLD USAGE
        PersonOld tomOld = new PersonOld("tom", 19);
        PersonOld dickOld = new PersonOld("dick", 21);
        PersonOld harryOld = new PersonOld("harry", 32);
        System.out.println(tomOld.getAge());
        System.out.println(tomOld);
        System.out.println(tomOld.equals(dickOld));
        System.out.println(harryOld.hashCode());


        // New USAGE
        PersonNew tomNew = new PersonNew("tom", 19);
        PersonNew dickNew = new PersonNew("dick", 21);
        PersonNew harryNew = new PersonNew("harry", 32);
        System.out.println(tomNew.age());               /// <<<<< This is GETTER
        System.out.println(tomNew);
        System.out.println(tomNew.equals(dickNew));
        System.out.println(harryNew.hashCode());
    }
}


