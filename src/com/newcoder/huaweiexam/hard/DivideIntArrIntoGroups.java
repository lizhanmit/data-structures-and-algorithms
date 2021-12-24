package com.newcoder.huaweiexam.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
 *
 * 本题含有多组样例输入。
 *
 * 数据范围：每个数组大小满足  ，输入的数据大小满足
 * 输入描述：
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述：
 * 返回true或者false
 *
 * 示例1
 * 输入：
 * 4
 * 1 5 -5 1
 * 3
 * 3 5 8
 * 复制
 * 输出：
 * true
 * false
 * 复制
 * 说明：
 * 第一个样例：
 * 第一组：5 -5 1
 * 第二组：1
 * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
 * 示例2
 * 输入：
 * 2
 * 8 -8
 * 复制
 * 输出：
 * true
 * 复制
 * 说明：
 * 由于可以将数组分为空数组，所以输出true。
 */
public class DivideIntArrIntoGroups {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            boolean canBeDivided = canBeDivided(arr);
            System.out.println(canBeDivided);
        }
    }

    private static boolean canBeDivided(int[] arr) {
        List<Integer> multiplesOf5List = new ArrayList<>();
        List<Integer> multiplesOf3List = new ArrayList<>();
        List<Integer> remainingList = new ArrayList<>();

        for (int i : arr) {
            if (i % 5 == 0) {
                multiplesOf5List.add(i);
            } else if (i % 3 == 0) {
                multiplesOf3List.add(i);
            } else {
                remainingList.add(i);
            }
        }

        int sum1 = 0;
        int sum2 = 0;

        for (Integer i : multiplesOf5List) {
            sum1 += i;
        }

        for (Integer i : multiplesOf3List) {
            sum2 += i;
        }

        return canBeDivided(sum1, sum2, remainingList, 0);
    }

    private static boolean canBeDivided(int sum1, int sum2, List<Integer> remainingList, int index) {
        if (index == remainingList.size()) {
            if (sum1 == sum2) {
                return true;
            } else {
                return false;
            }
        } else if (index < remainingList.size()) {
            return canBeDivided(sum1 + remainingList.get(index), sum2, remainingList, index + 1) || canBeDivided(sum1, sum2 + remainingList.get(index), remainingList, index + 1);
        } else {
            return false;
        }
    }
}
