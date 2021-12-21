package com.newcoder.huaweiexam.hard;

import java.util.*;

/**
 * 描述
 * 现有一组砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括 0
 *
 * 本题有多组输入
 *
 * 数据范围：每组输入数据满足  ，  ，
 * 输入描述：
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * 第一行：n --- 砝码数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述：
 * 利用给定的砝码可以称出的不同的重量数
 *
 * 示例1
 * 输入：
 * 2
 * 1 2
 * 2 1
 * 10
 * 4 185 35 191 26 148 149 3 172 147
 * 3 5 2 1 5 5 3 1 4 2
 * 复制
 * 输出：
 * 5
 * 3375
 */
public class MeasureWeights {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int numOfWeights = in.nextInt();

            int[] weightArr = new int[numOfWeights];
            for (int i = 0; i < numOfWeights; i++) {
                weightArr[i] = in.nextInt();
            }

            int[] weightNumArr = new int[numOfWeights];
            for (int i = 0; i < numOfWeights; i++) {
                weightNumArr[i] = in.nextInt();
            }

            int numOfMeasurement = numOfMeasurement(weightArr, weightNumArr);

            System.out.println(numOfMeasurement);
        }
    }

    private static int numOfMeasurement(int[] weightArr, int[] weightNumArr) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < weightArr.length; i++) {
            List<Integer> list = new ArrayList<>(set);
            for (int j = 1; j <= weightNumArr[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    set.add(list.get(k) + weightArr[i] * j);
                }
            }
        }

        return set.size();
    }
}
