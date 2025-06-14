package shl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Problem Description:
 * You are given an array that contains integers in ascending order followed by integers in descending order. All integers in the array are unique and appear only once.
 * Your task is to compute the product of the sum of the values in the ascending part and the sum of the values in the descending part of the array, then return the result modulo (10^9 + 7).
 *
 * Input Format:
 *     The first line contains a single integer N representing the total number of integers in the array.
 *     The second line contains N space-separated integers representing the values in the array.
 *
 * Output Format:
 *     Print a single integer representing the product of the sum of the ascending and descending parts of the array, modulo (10^9 + 7).
 *
 * Constraints:
 *     3 <= N <= 100000
 *     1 <= arr[i] <= 10^9
 */
public class LargeNumberMod {

    private static long calculate(int[] arr) {
        int MOD = 1000000007;

        int indexOfMaxNum = indexOfMaxNum(arr);

        long sumOfAsc = 0;
        for (int i = 0; i <= indexOfMaxNum; i++) {
            sumOfAsc += arr[i];
        }

        long sumOfDesc = 0;
        for (int i = indexOfMaxNum + 1; i < arr.length; i++) {
            sumOfDesc += arr[i];
        }

        // Directly multiplying two such large sums could cause overflow in Java
        // Modular arithmetic property: (a × b) mod m = [(a mod m) × (b mod m)]
        return ((sumOfAsc % MOD) * (sumOfDesc % MOD)) % MOD;
    }

    /**
     * Use binary search approach.
     * Time complexity: O(n)
     *
     * @param arr
     * @return
     */
    private static int indexOfMaxNum(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex = 0;

        while (leftIndex < rightIndex) {
            midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (arr[midIndex] < arr[midIndex + 1]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex;
            }
        }

        return leftIndex;
    }

    @Test
    public void testCalculate() {
        assertEquals(0, calculate(new int[]{1, 2, 3}));
        assertEquals(825, calculate(new int[]{3, 8, 14, 12, 10, 7, 4}));
    }
}
