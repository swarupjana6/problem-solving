package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsTap extends ClimbingStairs {

    Map<Integer, Integer> memoized = new HashMap<>();

    @Override
    protected int noOfWays(int stairs) {
        return ways(stairs + 1);
    }

    protected int ways(int stairs) {
        // BASE CONDITION
        if (stairs <= 1) {
            memoized.put(stairs, stairs);
            return stairs;
        }

        // HYPOTHESIS
        int ways = ways(stairs - 1) + ways(stairs - 2);

        // INDUCTION
        memoized.put(stairs, ways);
        return ways;
    }

    protected int waysMemoized(int stairs) {
        return memoized.getOrDefault(stairs, ways(stairs));
    }

    protected int ways1(int stairs) {
        if (stairs <= 1) {
            memoized.put(stairs, stairs);
            return stairs;
        }

        // HYPOTHESIS
        int waysStairsMinus1 = ways1(stairs - 1);
        memoized.put(stairs - 1, waysStairsMinus1);
        int waysStairsMinus2 = ways1(stairs - 2);
        memoized.put(stairs - 2, waysStairsMinus2);
        int ways = waysStairsMinus1 + waysStairsMinus2;


        // INDUCTION
        memoized.put(stairs, ways);
        return ways;
    }
}
