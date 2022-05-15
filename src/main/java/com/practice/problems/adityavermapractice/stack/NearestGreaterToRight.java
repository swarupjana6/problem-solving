package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public abstract class NearestGreaterToRight {

    String LOG_STR = "{} {}\n I/P List \t\t\t:: {} \n O/P Indexes \t\t:: {} \n O/P Elements \t\t:: {} \n-------\n";

    public abstract List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex);

    protected void execute() {
        List<Integer> inputList = Arrays.asList(1, 3, 2, 4);
        List<Integer> outputList = nearestGreaterToRight(inputList, -1);

        String outputStr = outputList.stream().map(i -> i != -1 && i < outputList.size() ? inputList.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), " 'i' moving from left2right >>>>>>", inputList, outputList, outputStr);
    }
}
