package shl;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Problem Description
 * You are given two lists of positive integers. Write an algorithm to calculate the number of elements that are not common between the two lists.
 *
 * Input Format
 *     The first line of the input consists of an integer, listinput1_size, representing the number of elements in the first list (N).
 *     The second line consists of (N) space-separated integers representing the first list of positive integers.
 *     The third line consists of an integer, listinput2_size, representing the number of elements in the second list (M).
 *     The fourth line consists of (M) space-separated integers representing the second list of positive integers.
 *
 * Output Format
 *     Print a positive integer representing the count of elements that are not common between both lists.
 *
 * Constraints
 *     1 <= listinput1_size,listinput2_size<= 1000
 *     All integers in the lists are positive.
 */
public class UniqueNumbersBtwTwoLists {

    private static int count(int[] arr1, int[] arr2) {
        Map<Integer, Long> map1 = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        int count = 0;

        for (int i = 0; i < arr2.length; i++) {
            if (map1.containsKey(arr2[i])) {
                map1.put(arr2[i], 0L);
            } else {
                count++;
            }
        }

        int uniqueToArr1 = Math.toIntExact(map1.values().stream().collect(Collectors.summingLong(Long::longValue)));
        return uniqueToArr1 + count;
    }

    @Test
    public void testCount() {
        assertEquals(12, count(new int[]{1, 1, 2, 3, 4, 5, 5, 7, 6, 9, 10}, new int[]{11, 12, 13, 4, 5, 6, 7, 18, 19, 20}));
        assertEquals(0, count(new int[]{1, 2}, new int[]{2, 1}));
    }
}
