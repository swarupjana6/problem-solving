package com.practice.javaconcepts.jvm;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HeadVsTailRecursionFactorial {

    public static void main(String[] args) {
        long startTime;
        long input = 5;

        startTime = System.currentTimeMillis();
        log.info("headRecursiveFactorial({}) -> {} ", input, headRecursiveFactorial(input));
        log.info("Execution time headRecursiveFactorial: {} ms ", System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        log.info("tailRecursiveFactorial({}) : {}", input, tailRecursiveFactorial(input, 1));
        log.info("Execution time tailRecursiveFactorial {} ", System.currentTimeMillis() - startTime);
    }

    // After recursion returns another operation is performed -> n * (value of returned function)
    public static Long headRecursiveFactorial(long n) {
        if (n == 0 || n == 1) return 1l;
        else return n * headRecursiveFactorial(n - 1);
    }

    // After recursion returns NO operation is performed -> (value of returned function)
    public static Long tailRecursiveFactorial(long n, long a) {
        if (n == 0 || n == 1) return a;
        else return tailRecursiveFactorial(n - 1, n * a);
    }
}
