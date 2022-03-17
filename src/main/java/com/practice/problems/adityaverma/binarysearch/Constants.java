package com.practice.problems.adityaverma.binarysearch;

import com.practice.lib.TriPredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Constants {

    Function<Integer, Integer> DECREASE_MID = mid -> mid - 1;

    Function<Integer, Integer> INCREASE_MID = mid -> mid + 1;

    Predicate<List<Integer>> IS_DESC = list -> list.get(0) > list.get(1);

    BiPredicate<Integer, Integer> MIDDLE_EQUAL_TO_ELEMENT = (midElement, element) ->  midElement == element;

    BiPredicate<Integer, Integer> MIDDLE_LESS_THAN_ELEMENT = (midElement, element) -> midElement < element;

    TriPredicate<List<Integer>, Integer, Integer> MID_LESS_THAN_EQUAL_END = (list, mid, end) -> list.get(mid) <= list.get(end);

    TriPredicate<List<Integer>, Integer, Integer> MID_GREATER_THAN_EQUAL_START = (list, mid, start) -> list.get(mid) >= list.get(start);

    BiPredicate<List<Integer>, Integer> MID_LESS_THAN_PREV = (list, mid) -> {
        int size = list.size();
        int prev = (mid - 1 + size) % size;         /* Modulo is done because to avoid -ve calculation */

        return list.get(mid) <= list.get(prev);
    };

    BiPredicate<List<Integer>, Integer> MID_LESS_THAN_NEXT = (list, mid) -> {
        int size = list.size();
        int next = (mid + 1) % size;                /* Modulo is done because to avoid out of bound calculation */

        return list.get(mid) <= list.get(next);
    };

    BiPredicate<List<Integer>, Integer> MID_LESS_THAN_PREV_NEXT = MID_LESS_THAN_PREV.and(MID_LESS_THAN_NEXT);

    default List<Integer> getDescendingList(List<Integer> inputList) {
        List<Integer> descendingList = new ArrayList<>(inputList);
        descendingList.sort(Comparator.reverseOrder());
        return descendingList;
    }

    static List<Integer> getAscendingList(List<Integer> inputList) {
        List<Integer> ascendingList = new ArrayList<>(inputList);
        ascendingList.sort(Comparator.naturalOrder());
        return ascendingList;
    }
}
