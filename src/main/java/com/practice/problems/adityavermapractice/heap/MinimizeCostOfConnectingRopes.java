package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;


/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to the sum of their lengths.
 * We need to connect the ropes with minimum cost.
 * <p>
 * For example, if we are given 4 ropes of lengths 4, 3, 2, and 6. We can connect the ropes in the following ways.
 * 1) First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three strings of 3, 2, and 10), then connect 10 and 3 (we get two strings of 13 and 2). Finally, we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 **/

@Log4j2
public abstract class MinimizeCostOfConnectingRopes {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;

    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer minimizeCost(List<Integer> ropes);

    public void execute() {
        List<Integer> input = List.of(4, 3, 5, 2, 1);
        Integer actual = minimizeCost(input);
        Integer expected = 33;

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
