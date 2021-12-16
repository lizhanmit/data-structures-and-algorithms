package com.newcoder.huaweiexam.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 数据范围：每组数据长度满足  ， 数据大小满足
 * 本题含有多组样例输入
 *
 *
 * 输入描述：
 * 输入多组数据，1组有2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 *
 * 输出描述：
 * 一组输出一个结果
 *
 * or
 *
 * 最长递增子序列
 */
public class Redraiment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int maxNumOfSteps = maxNumOfSteps(arr);

            System.out.println(maxNumOfSteps);
        }

    }

    // use dynamic programming
    private static int maxNumOfSteps(int[] arr) {
        int[] dp = new int[arr.length]; //记录到第i个木桩最多走多少步

        Arrays.fill(dp, 1);

        int maxNumOfSteps = 0;

        for(int i = 1; i < arr.length; i++){
            //选一个木桩
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                maxNumOfSteps = Math.max(maxNumOfSteps, dp[i]);
            }
        }
        return maxNumOfSteps;
    }
}
