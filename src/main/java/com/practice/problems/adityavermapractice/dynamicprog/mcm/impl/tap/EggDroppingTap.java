package com.practice.problems.adityavermapractice.dynamicprog.mcm.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.mcm.EggDropping;

import java.util.HashMap;
import java.util.Map;

public class EggDroppingTap extends EggDropping {

    Map<String, Integer> cached = new HashMap<>();

    @Override
    protected Integer eggDroppingMemoized(int eggs, int floors) {
        String key = eggs + "-" + floors;
        if (cached.containsKey(key)) return cached.get(key);
        if (floors == 1 || floors == 0) return floors;
        if (eggs == 1) return floors;

        int minimum = Integer.MAX_VALUE;
        for (int partition = 1; partition < floors; partition++) {
            String eggBrokeKey = (eggs - 1) + "-" + (partition - 1);
            String eggBrokeNoKey = (eggs) + "-" + (floors - partition);
            int eggBrokeYesAttempts;
            int eggBrokeNoAttempts;

            if (cached.containsKey(eggBrokeKey)) eggBrokeYesAttempts = cached.get(eggBrokeKey);
            else eggBrokeYesAttempts = eggDroppingRecursive(eggs - 1, partition - 1);

            if (cached.containsKey(eggBrokeNoKey)) eggBrokeNoAttempts = cached.get(eggBrokeNoKey);
            else eggBrokeNoAttempts = eggDroppingRecursive(eggs, floors - partition);

            int max = 1 + Math.max(eggBrokeYesAttempts, eggBrokeNoAttempts);
            minimum = Math.min(max, minimum);
        }

        cached.put(key, minimum);
        return minimum;
    }

    @Override
    protected Integer eggDroppingRecursive(int eggs, int floors) {
        if (floors == 1 || floors == 0) return floors;
        if (eggs == 1) return floors;

        int minimum = Integer.MAX_VALUE;
        for (int partition = 1; partition < floors; partition++) {
            int eggBrokeYesAttempts = eggDroppingRecursive(eggs - 1, partition - 1);
            int eggBrokeNoAttempts = eggDroppingRecursive(eggs, floors - partition);

            int max = 1 + Math.max(eggBrokeYesAttempts, eggBrokeNoAttempts);
            minimum = Math.min(max, minimum);
        }

        return minimum;
    }
}
