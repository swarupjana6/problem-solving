package com.practice.designpattern.strategy;

import java.util.List;

public class TraditionalWay {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(getContext("Total").executeStrategy(nums));
        System.out.println(getContext("TotalEven").executeStrategy(nums));
        System.out.println(getContext("TotalOdd").executeStrategy(nums));
    }

    private static Context getContext(String action) {
        Context context = new Context();
        if (action == "Total") context.setStrategy(new Total());
        else if (action == "TotalEven") context.setStrategy(new EvenTotal());
        else if (action == "TotalOdd") context.setStrategy(new OddTotal());
        return context;
    }
}

interface TotalValues {
    int totalValues(List<Integer> values);
}

class Total implements TotalValues {

    @Override
    public int totalValues(List<Integer> values) {
        int total = 0;
        for (int e : values) total += e;
        return total;
    }
}

class EvenTotal implements TotalValues {

    @Override
    public int totalValues(List<Integer> values) {
        int total = 0;
        for (int e : values) if (e % 2 == 0) total += e;
        return total;
    }
}

class OddTotal implements TotalValues {

    @Override
    public int totalValues(List<Integer> values) {
        int total = 0;
        for (int e : values) if (e % 2 == 0) total += e;
        return total;
    }
}


class Context {
    private TotalValues strategy;

    void setStrategy(TotalValues strategy) {
        this.strategy = strategy;
    }

    int executeStrategy(List<Integer> nums) {
        return strategy.totalValues(nums);
    }
}
