package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class MinimumElementStack {

    final BiConsumer<Integer, Integer> IS_ACTUAL_INTEGER_VALID = Assertions::assertEquals;

    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract void push(Integer element);

    public abstract Integer pop();

    public abstract Integer min();

    public abstract Integer peek();

    public void execute() {
        //example1();
        example2();
    }

    private void example1() {
        List<Integer> input = List.of(18, 19, 29, 15, 16);
        input.stream().forEach(element -> this.push(element));
        Integer actual = this.min();
        Integer expected = 15;

        log.debug(LOG_STR, input, actual, expected);
        IS_ACTUAL_INTEGER_VALID.accept(actual, expected);
    }

    private void example2() {
        List<Integer> input = List.of(5, 3, 2);
        input.stream().forEach(element -> this.push(element));
        System.out.println(this.peek());
        this.pop();
        System.out.println(this.peek());
        Integer actual = this.min();
        Integer expected = 3;

        log.debug(LOG_STR, input, actual, expected);
        IS_ACTUAL_INTEGER_VALID.accept(actual, expected);
    }
}
