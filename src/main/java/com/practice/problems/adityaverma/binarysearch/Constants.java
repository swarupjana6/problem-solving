package com.practice.problems.adityaverma.binarysearch;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Constants {

    Function<Integer, Integer> DECREASE_MID = mid -> mid - 1;

    Function<Integer, Integer> INCREASE_MID = mid -> mid + 1;

    Predicate<List<Integer>> IS_DESC = list -> list.get(0) > list.get(1);

}
