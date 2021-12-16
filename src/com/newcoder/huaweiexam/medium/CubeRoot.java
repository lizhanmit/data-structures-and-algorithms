package com.newcoder.huaweiexam.medium;

import java.util.Scanner;

/**
 * 描述
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 * <p>
 * 数据范围：
 * <p>
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 * <p>
 * 输出描述：
 * 输入参数的立方根。保留一位小数。
 */
public class CubeRoot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double input = in.nextDouble();

        double cubeRoot = cubeRoot(input);
        //double cubeRoot = cubeRoot2(input);

        System.out.printf("%.1f", cubeRoot);

    }

    // use binary search
    private static double cubeRoot(double n) {
        double right, left, mid = 0.0;
        //一定要注意边界条件，输入的num可能是负数  将x<-1的边界范围定为[x,1]，x>1的边界范围定为[-1,x]
        right = Math.max(1.0, n);
        left = Math.min(-1.0, n);

        while (right - left > 0.001) {
            mid = (left + right) / 2;
            //如果乘积大于num，说明立方根在mid的左侧
            if (mid * mid * mid > n) {
                right = mid;
            }
            //如果乘积小于num，说明立方根在mid的右侧
            else if (mid * mid * mid < n) {
                left = mid;
            } else {
                return mid;
            }
        }
        return right;
    }

    // use Newton iterative method
    private static double cubeRoot2(double n) {
        //判断输入是否为0 为0直接返回
        if (n == 0) {
            return 0;
        }

        double x0 = n;
        double x1 = (2 * x0 + n / (x0 * x0)) / 3;
        //迭代结束的条件
        while (Math.abs(x1 - x0) > 0.0001) {
            x0 = x1;
            //更新x1
            x1 = (2 * x0 + n / (x0 * x0)) / 3;
        }
        //最终结果
        return x1;
    }

}
