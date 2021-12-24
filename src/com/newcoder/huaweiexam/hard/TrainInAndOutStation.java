package com.newcoder.huaweiexam.hard;

import java.util.*;

/**
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 有多组测试用例，每一组第一行输入一个正整数N（0
 *
 * 输出描述：
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 * 示例1
 * 输入：
 * 3
 * 1 2 3
 * 复制
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 复制
 * 说明：
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class TrainInAndOutStation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            
            List<String> strategies = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            trainOutStation(0,0, arr, stack, strategies, "");

            Collections.sort(strategies);
            strategies.forEach(System.out::println);
        }

    }

    public static void trainOutStation(int i, int j, int[] a, Stack<Integer> input, List<String> list, String output) {
        if (i == j && j == a.length) {
            list.add(output);
            return;
        }
        if (i != a.length) {
            input.push(a[i]);
            trainOutStation(i + 1, j, a, input, list, output);
            input.pop();
        }
        if (!input.isEmpty()) {
            int x = input.pop();
            trainOutStation(i, j + 1, a, input, list, output + x + " ");
            input.push(x);
        }
    }
}
