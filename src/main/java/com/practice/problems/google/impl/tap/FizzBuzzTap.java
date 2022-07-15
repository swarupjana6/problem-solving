package com.practice.problems.google.impl.tap;

import com.practice.problems.google.FizzBuzz;

public class FizzBuzzTap extends FizzBuzz {
    @Override
    protected String[] fizzBuzz(Integer num) {
        String[] result = new String[num];
        String tempResult;

        for (int i = 1; i <= num; i++) {
            tempResult = "";
            int modulo3 = i % 3;
            int modulo5 = i % 5;

            if (modulo3 != 0 && modulo5 != 0) tempResult = String.valueOf(i);
            else {
                if (modulo3 == 0) tempResult += "Fizz";
                if (modulo5 == 0) tempResult += "Buzz";
            }

            result[i - 1] = tempResult;
        }

        return result;
    }
}
