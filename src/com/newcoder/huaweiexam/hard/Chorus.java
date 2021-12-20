package com.newcoder.huaweiexam.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N 位同学站成一排，音乐老师要请其中的 (N - K) 位同学出列，使得剩下的 K 位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为 T1，T2，…，TK ，   则他们的身高满足存在 i （1<=i<=K） 使得 T1<T2<......<Ti-1<Ti>Ti+1>......>TK 。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * 请注意处理多组输入输出！
 *
 * 数据范围：
 *
 * 输入描述：
 * 有多组用例，每组都包含两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 复制
 * 输出：
 * 4
 * 复制
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class Chorus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //同学的总数
            int n = sc.nextInt();
            //N位同学的身高
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            //dp1[i]表示该位置结尾的最长递增子序列长度
            int[] dp1 = new int[n];
            //给dp1数组赋初值
            Arrays.fill(dp1, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    //如果i位置同学身高大于j位置同学，则可以排在j位置同学后面
                    if (arr[j] < arr[i]) {
                        dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                    }
                }
            }

            //dp2[i]表示该位置开头的最长递减子序列长度
            int[] dp2 = new int[n];
            //给dp2数组赋初值
            Arrays.fill(dp2, 1);
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    /*如果i位置同学身高大于j位置同学，则可以排在j位置同学后面
                    反过来，则是j可排在i同学后面，构成递减子序列*/
                    if (arr[j] < arr[i]) {
                        dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                    }
                }
            }

            //统计每个位置的合唱队形长度最大值
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp1[i] + dp2[i] - 1);
            }

            System.out.println(n - max);
        }
    }
}
