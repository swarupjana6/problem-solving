package com.practice.problems.google.impl.tap;

import com.practice.problems.google.FindAllNumbersDisappeared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAllNumbersDisappearedTap extends FindAllNumbersDisappeared {
    @Override
    protected List<Integer> disappearedNumbers(int[] digits) {
        List<Integer> results = new ArrayList<>();

        Set<Integer> uniqueNums = new HashSet<>();
        for (int digit : digits) uniqueNums.add(digit);

        for (int i = 1; i <= digits.length; i++)
            if (!uniqueNums.contains(i)) results.add(i);

        return results;
    }
}
