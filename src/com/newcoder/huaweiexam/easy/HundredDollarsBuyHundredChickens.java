package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 *
 * 输出描述：
 *  输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 */
public class HundredDollarsBuyHundredChickens {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (in.hasNextInt()) {
            waysToBuyHundredChickens();
        }
    }

    // use mathematical equations
    // numOfCocks + numOfHens + numOfChicks = 100
    // 5 * numOfCocks + 3 * numOfHens + (1 / 3) * numOfChicks = 100
    // as a result, 7 * numOfCocks + 4 * numOfHens = 100, and numOfCocks cannot be greater than 14
    private static void waysToBuyHundredChickens() {
        int numOfCocks, numOfHens, numOfChicks;

        for (numOfCocks = 0; numOfCocks <= 14; numOfCocks++) {
            if ((100 - 7 * numOfCocks) % 4 == 0) {  // numOfHens must be integral
                numOfHens = (100 - 7 * numOfCocks) / 4;
                numOfChicks = 100 - numOfCocks - numOfHens;

                System.out.printf("%d %d %d %n", numOfCocks, numOfHens, numOfChicks);
            }
        }
    }
}
