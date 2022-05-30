package com.practice.problems.adityavermapractice.binarysearch;

import java.util.Arrays;
import java.util.List;

import static com.practice.problems.adityavermapractice.binarysearch.AllocatePagesOfBooks.noOfPages;
import static com.practice.problems.adityavermapractice.binarysearch.BinarySearch.asc;
import static com.practice.problems.adityavermapractice.binarysearch.BinarySearch.search;
import static com.practice.problems.adityavermapractice.binarysearch.CeilFloorOfElement.ceil;
import static com.practice.problems.adityavermapractice.binarysearch.CeilFloorOfElement.floor;
import static com.practice.problems.adityavermapractice.binarysearch.CountOfAnElement.countOccurrences;
import static com.practice.problems.adityavermapractice.binarysearch.ElementsInRotatedArray.searchInRotated;
import static com.practice.problems.adityavermapractice.binarysearch.FindElementInAnInfiniteArray.infiniteSearch;
import static com.practice.problems.adityavermapractice.binarysearch.First1InBinarySortedArray.searchInBinary;
import static com.practice.problems.adityavermapractice.binarysearch.FirstAndLastOccurrenceElement.firstOccurrence;
import static com.practice.problems.adityavermapractice.binarysearch.FirstAndLastOccurrenceElement.lastOccurrence;
import static com.practice.problems.adityavermapractice.binarysearch.MinimumDifference.minDiff;
import static com.practice.problems.adityavermapractice.binarysearch.NearlySortedArray.searchInNearlySorted;
import static com.practice.problems.adityavermapractice.binarysearch.NextLetter.ceilChar;
import static com.practice.problems.adityavermapractice.binarysearch.NextLetter.floorChar;
import static com.practice.problems.adityavermapractice.binarysearch.NumberOfTimesRotated.findPivot;
import static com.practice.problems.adityavermapractice.binarysearch.PeakElement.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BinarySearchProblems {

    public static void main(String[] args) {
        assertEquals(0, search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));
        assertEquals(7, search(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 9));

        assertEquals(3, firstOccurrence(new int[]{1, 2, 3, 5, 5, 5, 5, 5, 9, 10}, 5));
        assertEquals(7, lastOccurrence(new int[]{1, 2, 3, 5, 5, 5, 5, 5, 9, 10}, 5));

        assertNotEquals(5, firstOccurrence(new int[]{1, 2, 3, 5, 5, 5, 5, 5, 9, 10}, 5));
        assertNotEquals(10, lastOccurrence(new int[]{1, 2, 3, 5, 5, 5, 5, 5, 9, 10}, 5));

        assertEquals(5, countOccurrences(new int[]{1, 2, 3, 5, 5, 5, 5, 5, 9, 10}, 5));

        assertEquals(4, findPivot(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(3, findPivot(new int[]{5, 6, 7, 0, 1, 2, 4}));
        assertEquals(1, findPivot(new int[]{7, 0, 1, 2, 4, 5, 6}));

        assertEquals(1, searchInRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));

        assertEquals(0, searchInNearlySorted(new int[]{5, 10, 30, 20, 40}, 5));
        assertEquals(3, searchInNearlySorted(new int[]{5, 10, 30, 20, 40}, 20));

        assertEquals(4, floor(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 5));
        assertEquals(8, ceil(new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19}, 5));

        assertEquals('g', ceilChar(new char[]{'a', 'b', 'c', 'g', 'i', 'l'}, 'd'));
        assertEquals('c', floorChar(new char[]{'a', 'b', 'c', 'g', 'i', 'l'}, 'd'));
        assertEquals('i', ceilChar(new char[]{'a', 'b', 'c', 'g', 'i', 'l'}, 'g'));
        assertEquals('c', floorChar(new char[]{'a', 'b', 'c', 'g', 'i', 'l'}, 'g'));

        assertEquals(8, infiniteSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 9));

        assertEquals(6, searchInBinary(new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));

        assertEquals(10, minDiff(new int[]{1, 3, 8, 10, 15}, 12));

        assertEquals(2, peak(new int[]{5, 10, 20, 15}));

        assertEquals(3, bitonic(new int[]{1, 3, 8, 12, 4, 2}));
        assertEquals(5, bitonic(new int[]{1, 3, 8, 12, 14, 22}));
        assertEquals(0, bitonic(new int[]{111, 13, 8, 6, 4, 2}));
        assertEquals(3, bitonic(new int[]{1, 3, 5, 111, 6, 4, 2}));
        assertEquals(4, bitonicSearch(new int[]{1, 3, 5, 111, 6, 4, 2}, 6));


        int[][] input = new int[][]{{10, 20, 30, 40}
                , {15, 25, 35, 45}
                , {27, 29, 37, 48}
                , {32, 33, 39, 50}};
        assertEquals(List.of(2, 1), TwoDArray.searchIn2D(input, 29));
        assertEquals(List.of(-1, -1), TwoDArray.searchIn2D(input, 99));

        assertEquals(40, noOfPages(new int[]{10, 20, 30, 40}, 2));
        //assertEquals(100, noOfPages(new int[]{10, 20, 30, 40, 50, 60}, 2));
    }
}

class BinarySearch {

    public static int search(int[] numbers, int num) {
        if (numbers.length == 1) return 0;

        int start = 0;
        int end = numbers.length - 1;

        return search(numbers, num, start, end);
    }

    public static int search(int[] numbers, int number, int start, int end) {
        boolean isAsc = numbers[start] < numbers[end];
        return isAsc ? asc(numbers, number, start, end) : desc(numbers, number, start, end);
    }

    public static int asc(int[] nums, int number, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (number == nums[mid]) return mid;
            else if (number > nums[mid]) start = mid + 1;
            else if (number < nums[mid]) end = mid - 1;
        }
        return -1;
    }

    public static int desc(int[] nums, int number, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (number == nums[mid]) return mid;
            else if (number < nums[mid]) start = mid + 1;
            else if (number > nums[mid]) end = mid - 1;
        }
        return -1;
    }
}

class FirstAndLastOccurrenceElement {

    public static int firstOccurrence(int[] nums, int number) {
        int start = 0;
        int end = nums.length - 1;
        return first(nums, number, start, end);
    }

    public static int lastOccurrence(int[] nums, int number) {
        int start = 0;
        int end = nums.length - 1;
        return last(nums, number, start, end);
    }

    public static int first(int[] nums, int number, int start, int end) {
        int first = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (number == nums[mid]) {
                first = mid;
                end = mid - 1;
            } else if (number > nums[mid]) start = mid + 1;
            else if (number < nums[mid]) end = mid - 1;
        }
        return first;
    }

    public static int last(int[] nums, int number, int start, int end) {
        int last = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (number == nums[mid]) {
                last = mid;
                start = mid + 1;
            } else if (number > nums[mid]) start = mid + 1;
            else if (number < nums[mid]) end = mid - 1;
        }
        return last;
    }
}

class CountOfAnElement {
    public static int countOccurrences(int[] nums, int number) {
        int first = firstOccurrence(nums, number);
        int last = lastOccurrence(nums, number);
        return last - first + 1;
    }
}

class NumberOfTimesRotated {

    public static int findPivot(int[] nums) {
        if (nums.length == 1) return 0;

        int start = 0;
        int end = nums.length - 1;

        return findPivot(nums, start, end);
    }

    private static int findPivot(int[] nums, int start, int end) {
        int len = nums.length;

        while (start <= end) {
            if (nums[start] <= nums[end]) return start;

            int mid = start + ((end - start) / 2);
            int prev = (len + (mid - 1)) % len;
            int next = (mid + 1) % len;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) return mid;

            if (nums[start] <= nums[mid]) start = next;
            else end = prev;
        }

        return -1;
    }
}

class ElementsInRotatedArray {

    public static int searchInRotated(int[] numbers, int number) {
        int len = numbers.length;
        if (len == 1) return 0;
        int start = 0;
        int end = len - 1;
        int pivot = findPivot(numbers);

        int result;
        if (numbers[pivot] == number) return pivot;

        if (numbers[pivot] <= number && number <= numbers[end]) return asc(numbers, number, pivot + 1, end);
        else return asc(numbers, number, start, pivot - 1);
    }
}

class NearlySortedArray {

    public static int searchInNearlySorted(int[] numbers, int number) {
        int len = numbers.length;
        if (len == 1 && number == numbers[len - 1]) return 0;
        else if (len == 1) return -1;

        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = (start + (end - start)) / 2;

            if (numbers[mid] == number) return mid;
            else if (numbers[mid - 1] == number) return mid - 1;
            else if (numbers[mid + 1] == number) return mid + 1;
            else if (number > numbers[mid + 1]) start = mid + 2;
            else if (number < numbers[mid - 1]) end = mid - 2;
        }

        return -1;
    }
}

class CeilFloorOfElement {

    public static int ceil(int[] numbers, int element) {
        int len = numbers.length;
        int start = 0;
        int end = len - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == numbers[mid]) return mid;
            else if (element > numbers[mid]) start = mid + 1;
            else if (element < numbers[mid]) {
                result = mid;
                end = mid - 1;
            }
        }

        return numbers[result];
    }

    public static int floor(int[] numbers, int element) {
        int len = numbers.length;
        int start = 0;
        int end = len - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == numbers[mid]) return mid;
            else if (element < numbers[mid]) end = mid - 1;
            else if (element > numbers[mid]) {
                result = mid;
                start = mid + 1;
            }
        }

        return numbers[result];
    }
}

class NextLetter {

    public static char ceilChar(char[] letters, char element) {
        int result = ceil(letters, element);
        if (result != -1) return letters[result];
        return '-';
    }

    public static int ceil(char[] letters, char element) {
        int len = letters.length;
        int start = 0;
        int end = len - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == letters[mid]) start = mid + 1;
            else if (element > letters[mid]) start = mid + 1;
            else if (element < letters[mid]) {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }

    public static char floorChar(char[] letters, char element) {
        int result = floor(letters, element);
        if (result != -1) return letters[result];
        return '-';
    }

    public static int floor(char[] letters, char element) {
        int len = letters.length;
        int start = 0;
        int end = len - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == letters[mid]) end = mid - 1;
            else if (element < letters[mid]) end = mid - 1;
            else if (element > letters[mid]) {
                result = mid;
                start = mid + 1;
            }
        }

        return result;
    }
}

class FindElementInAnInfiniteArray {

    public static int infiniteSearch(int[] nums, int number) {
        if (nums.length == 1) return 0;

        int start = 0;
        int end = 1;

        return infiniteSearch(nums, number, start, end);
    }

    public static int infiniteSearch(int[] numbers, int number, int start, int end) {
        while (number > end) {
            start = end;
            end = end * 2;
        }

        return BinarySearch.asc(numbers, number, start, end);
    }

}

class First1InBinarySortedArray {

    public static int searchInBinary(int[] numbers) {
        int start = 0;
        int end = 1;
        int number = 1;

        while (numbers[end] < number) {
            start = end;
            end = end * 2;
        }

        return FirstAndLastOccurrenceElement.first(numbers, number, start, end);
    }
}

class MinimumDifference {

    public static int minDiff(int[] numbers, int number) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (number == numbers[mid]) return mid;
            else if (number > numbers[mid]) start = mid + 1;
            else if (number < numbers[mid]) end = mid - 1;
        }

        int min1 = Math.abs(numbers[start] - number);
        int min2 = Math.abs(numbers[end] - number);
        int minIndex = min1 < min2 ? start : end;

        return numbers[minIndex];
    }
}

class PeakElement {
    public static int peak(int[] numbers) {
        int len = numbers.length;
        int start = 0;
        int end = len - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < len - 1) {
                if (numbers[mid - 1] < numbers[mid] && numbers[mid] > numbers[mid + 1]) return mid;
                else if (numbers[mid - 1] > numbers[mid]) end = mid - 1;
                else if (numbers[mid + 1] > numbers[mid]) start = mid + 1;
            } else if (mid == 0) {
                if (numbers[mid] > numbers[mid + 1]) return mid;
                else return mid + 1;
            } else if (mid == len - 1) {
                if (numbers[mid] > numbers[mid - 1]) return mid;
                else return mid - 1;
            }
        }

        return -1;
    }

    public static int bitonic(int[] numbers) {
        return peak(numbers);
    }

    public static int bitonicSearch(int[] numbers, int number) {
        int peakIndex = peak(numbers);

        int firstHalf = BinarySearch.asc(numbers, number, 0, peakIndex);
        if (firstHalf != -1) return firstHalf;
        int secondHalf = BinarySearch.desc(numbers, number, peakIndex + 1, numbers.length - 1);
        return secondHalf;
    }
}

class TwoDArray {

    public static List<Integer> searchIn2D(int[][] numbers, int target) {
        int row = 0;
        int col = numbers.length - 1;

        while (row <= numbers[0].length - 1 && col >= 0) {
            if (numbers[row][col] == target) return List.of(row, col);
            else if (numbers[row][col] > target) col--;
            else if (numbers[row][col] < target) row++;

        }
        return List.of(-1, -1);
    }
}

class AllocatePagesOfBooks {

    public static int noOfPages(int[] books, int students) {
        int noOfBooks = books.length;
        if (noOfBooks < students) return -1;
        int start = Arrays.stream(books).max().getAsInt();
        int end = Arrays.stream(books).sum();
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(books, mid, students)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] books, int mid, int students) {
        int studentCount = 1;
        int sum = 0;
        for (int book : books) {
            sum += book;
            if (sum > mid) {
                studentCount++;
                sum = book;
            }
            return studentCount > students ? false : true;
        }
        return true;
    }
}

