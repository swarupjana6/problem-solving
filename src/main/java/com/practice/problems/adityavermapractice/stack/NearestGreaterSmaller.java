package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Log4j2
public abstract class NearestGreaterSmaller {

    protected String LOG_STR = "{} {}\n I/P List \t\t\t:: {} \n O/P Indexes \t\t:: {} \n O/P Elements \t\t:: {} \n-------\n";

    protected abstract void execute();

    protected void test(List<Integer> input, List<Integer> actual, String indexMovement, Consumer<List<Integer>> expectedValidator) {
        String outputStr = actual.stream().map(i -> i != -1 && i < actual.size() ? input.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), indexMovement, input, actual, outputStr);
        expectedValidator.accept(actual);
    }
}
