package com.practice.problems.adityavermapractice.binarysearch;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;


/**
 * Given number of pages in N different books and M students.
 * The books are arranged in ascending order of number of pages.
 * Every student is assigned to read some consecutive books.
 * The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 *
 * **/
@Log4j2
public abstract class AllocateMinimumNoOfPages {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            I/P Arr             :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    public abstract Integer allocateBooks(int[] books, int students);

    public void execute() {
        int[] books;
        int students;
        int actual;
        int expected;

        books = new int[]{10, 20, 30, 40, 50, 90};
        students = 2;
        expected = 2;
        actual = allocateBooks(books, students);
        log.debug(LOG_STR, getClass().getSimpleName(), books, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
