package com.newcoder.huaweiexam.hard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 描述
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * 请注意本题有多组样例。
 *
 *
 *
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述：
 * 输出合并之后的数组
 *
 * 示例1
 * 输入：
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 * 复制
 * 输出：
 * -101235
 */
public class MergeTwoIntArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int numOfArr1 = in.nextInt();
            int[] arr1 = new int[numOfArr1];
            for (int i = 0; i < numOfArr1; i++) {
                arr1[i] = in.nextInt();
            }

            int numOfArr2 = in.nextInt();
            int[] arr2 = new int[numOfArr2];
            for (int i = 0; i < numOfArr2; i++) {
                arr2[i] = in.nextInt();
            }

            Set<Integer> mergedSet = mergeTwoIntArrays(arr1, arr2);
            mergedSet.forEach(System.out::print);

            // NOTE here, for multiple inputs (while()), remember to println if there is only print above
            System.out.println();
        }
    }

    // deduplicate -> set
    // sorted set -> TreeSet
    private static Set<Integer> mergeTwoIntArrays(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();

        Arrays.stream(arr1).forEach(set::add);
        Arrays.stream(arr2).forEach(set::add);

        return set;
    }
}
