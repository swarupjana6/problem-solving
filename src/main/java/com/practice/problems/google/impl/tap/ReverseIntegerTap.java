package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ReverseInteger;

public class ReverseIntegerTap extends ReverseInteger {
    @Override
    protected Integer reverseInteger(Integer num) {
        int sign = num < 0 ? -1 : 1;
        num *= sign;

        long reverse = 0;
        int remainder = num % 10;
        while (num > 0 && remainder == 0) {
            num = num / 10;
            remainder = num % 10;
        }

        while (num > 0) {
            reverse *= 10;
            reverse += num % 10;
            num = num / 10;
        }

        if (reverse > Integer.MAX_VALUE) reverse = 0;
        return (int) reverse * sign;
    }
}
