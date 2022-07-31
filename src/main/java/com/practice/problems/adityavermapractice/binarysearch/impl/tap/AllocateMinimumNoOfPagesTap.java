package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.AllocateMinimumNoOfPages;

import java.util.Arrays;

public class AllocateMinimumNoOfPagesTap extends AllocateMinimumNoOfPages {

    private int students;

    private int[] books;

    @Override
    public Integer allocateBooks(int[] books, int students) {
        if(books.length < students) return -1;
        this.books = books;
        this.students = students;
        return minimizeMaxNoOfPages(books, students);
    }

    private int minimizeMaxNoOfPages(int[] books, int students) {
        int result = -1;
        int start = new PeakElementTap().indexOfPeak(books);
        int end = Arrays.stream(books).sum();

        while (start <= end) {
            int mid = start + (end - start)/2;

            if(isValid(mid, students)) {
                result = mid;
                end = mid - 1;      // Since we have to minimize so we move to left
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private boolean isValid(int mid, int students) {
        int student = 1;
        int sum = 0;

        for (int index = 0; index < books.length; index++) {
            sum += books[index];
            if(sum > mid) {
                student++;
                sum = books[index];
            }

            if(student > students) return false;
        }
        
        return true;
    }
}
