package com.newcoder.huaweiexam.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且不考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 * 输入描述：
 * 本题有多组案例。对于每组案例读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 * <p>
 * 输出描述：
 * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 */
public class Game24Points {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            String input = in.nextLine();

            boolean is24PointsAchievable = is24PointsAchievable(input);

            System.out.println(is24PointsAchievable);
        }
    }

    private static boolean is24PointsAchievable(String str) {
        String[] strArr = str.split(" ");

        double[] a = new double[4];

        for (int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(strArr[i]);
        }

        boolean[] visited = new boolean[4];
        Arrays.fill(visited, true);

        return dfs(a, 0, 0, visited);
    }

    private static boolean dfs(double[] a, double res, int idex, boolean[] visited) {
        if (idex >= 4) {
            return Math.abs(res - 24) == 0;
        }

        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (visited[i]) {
                visited[i] = false;
                flag = dfs(a, res + a[i], idex + 1, visited) || dfs(a, res - a[i], idex + 1, visited) || dfs(a, res * a[i], idex + 1, visited) || dfs(a, res / a[i], idex + 1, visited);
                visited[i] = true;
                if (flag == true) {
                    break;
                }
            }
        }
        return flag;
    }
}
