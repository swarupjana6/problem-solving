package com.practice.javaconcepts;

public class VarTypeInferenceExample {

    //DOES NOT WORK
    // private var instanceVar = "tom";

    public static void main(String[] args) {

        //DOES NOT WORK
        /**
         var localVar;
         localVar = "tom";
         **/

        String localStr = "tom";
        var localVar = "tom";
        var localVar1 = 19;
        var localVar2 = new Object();
    }
}
