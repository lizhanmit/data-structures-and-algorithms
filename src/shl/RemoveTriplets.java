package shl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * You are given an array of size n. You need to remove elements from the array in such a way that exactly three adjacent elements are removed in one turn. The elements that can be removed must satisfy the following conditions:
 *     The second element is k greater than the first element.
 *     The third element is k greater than the second element.
 * The goal is to continue removing such triplets until no further triplets can be removed, and return the size of the smallest possible array.
 *
 * Note: If the array becomes empty after removing all possible triplets, return -1.
 *
 * Input Format:
 *     The first line contains two integers n and k, where:
 *         n is the size of the array.
 *         k is the difference required between consecutive elements in the triplet.
 *     The second line contains n integers representing the elements of the array.
 *
 * Output Format:
 *     Return the size of the smallest possible array after removing all possible triplets. If the array becomes empty, return -1.
 *
 * Constraints:
 *     1 <= n <= 1000
 *     1 <= arr[i] <= 10^9
 */
public class RemoveTriplets {

    private static int sizeOfSmallestPossibleArr(int n, int k, int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        boolean isListChanged = true;
        while(isListChanged && list.size() >= 3) {
            isListChanged = false;
            for (int i = 0; i <= list.size() - 3; i++) {
                int first = list.get(i);
                int second = list.get(i + 1);
                int third = list.get(i + 2);
                int max = maxOfThree(first, second, third);
                int min = minOfThree(first, second, third);
                int mid = midOfThree(first, second, third);

                if (max - mid  == k && mid - min == k) {
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);

                    isListChanged = true;
                    break;
                }
            }
        }

        if (list.isEmpty()) {
            return -1;
        }

        return list.size();
    }

    private static int maxOfThree(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        }

        if (b >= a && b >= c) {
            return b;
        }

        return c;
    }

    private static int minOfThree(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }

        if (b <= a && b <= c) {
            return b;
        }

        return c;
    }

    private static int midOfThree(int a, int b, int c) {
        if (a >= b && a <= c) {
            return a;
        }

        if (b >= a && b <= c) {
            return b;
        }

        return c;
    }

    @Test
    public void testSizeOfSmallestPossibleArr() {
        assertEquals(-1, sizeOfSmallestPossibleArr(3, 1, new int[]{2, 1, 3}));
        assertEquals(1, sizeOfSmallestPossibleArr(10, 2, new int[]{2, 4, 6, 8, 10, 12, 8, 10, 6, 8}));
        assertEquals(3, sizeOfSmallestPossibleArr(6, 1, new int[]{12, 13, 14, 15, 16, 19}));
    }
}
