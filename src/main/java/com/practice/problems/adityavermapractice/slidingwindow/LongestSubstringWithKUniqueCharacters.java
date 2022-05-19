package com.practice.problems.adityavermapractice.slidingwindow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;


/**
 * Pick Toy
 * <p>
 * Given a string you need to print longest possible substring that has exactly M unique characters.
 * If there are more than one substring of longest possible length, then print any one of them.
 * <p>
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * <p>
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 * <p>
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 * <p>
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 **/


@Log4j2
public abstract class LongestSubstringWithKUniqueCharacters {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer LongestStringWithUniqueChars(String input, Integer uniqueChar);

    public void execute() {
        String input = "aabacbebebe";
        Integer uniqueChar = 3;
        Integer actual = LongestStringWithUniqueChars(input, uniqueChar);
        Integer expected = 7;

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
