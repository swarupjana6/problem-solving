package com.practice.problems.adityavermapractice.slidingwindow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;


/**
 * Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
 * An anagram of a word is a word that’s formed by rearranging the letters of the original word. For example: the anagrams of the word for are
 * <p>
 * for
 * fro
 * ofr
 * orf
 * rof
 * rfo
 * Note that, the anagrams use all the original letters exactly once.
 * <p>
 * Input: text = forxxorfxdofr, word = for
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
 * <p>
 * Input : text = aabaabaa, word = aaba
 * Output : 4
 * Explanation : Anagrams of the word aaba - aaba, abaa each appear twice in the text and hence the
 * count is 4.
 **/

@Log4j2
public abstract class CountOccurrenceOfAnagram {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer anagramCount(String inputList, String pattern);

    public void execute() {
        String input = "aabaabaa";
        String anagrams = "aaba";
        Integer actual = anagramCount(input, anagrams);
        Integer expected = 4;

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
