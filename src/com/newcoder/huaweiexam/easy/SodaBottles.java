package com.newcoder.huaweiexam.easy;

import java.util.Scanner;

/**
 * 描述
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是 5 瓶，方法如下：先用 9 个空瓶子换3瓶汽水，喝掉 3 瓶满的，喝完以后 4 个空瓶子，用 3 个再换一瓶，喝掉这瓶满的，这时候剩 2 个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用 3 个空瓶子换一瓶满的还给老板。如果小张手上有 n 个空汽水瓶，最多可以换多少瓶汽水喝？
 *
 * 数据范围：输入的正整数满足
 *
 * 注意：本题存在多组输入。
 * 允许如题面所述向老板借汽水。
 * 输入的 0 仅表示输入结束，并不用输出结果
 * 输入描述：
 * 输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（ 1<=n<=100 ），表示小张手上的空汽水瓶数。n=0 表示输入结束，你的程序不应当处理这一行。
 *
 * 输出描述：
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 */
public class SodaBottles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int numOfEmptyBottles = in.nextInt();

            if (numOfEmptyBottles == 0) {
                break;
            }

            //int countOfSodaBottles = countOfSodaBottles(numOfEmptyBottles);
            int countOfSodaBottles = countOfSodaBottles2(numOfEmptyBottles);

            System.out.println(countOfSodaBottles);
        }
    }

    // use IQ
    private static int countOfSodaBottles(int numOfEmptyBottles) {
        return numOfEmptyBottles / 2;
    }

    private static int countOfSodaBottles2(int numOfEmptyBottles) {
        int count = 0;

        while (numOfEmptyBottles / 3 > 0) {
            count += numOfEmptyBottles / 3;

            numOfEmptyBottles = numOfEmptyBottles / 3 + numOfEmptyBottles % 3;

            if (numOfEmptyBottles == 2) {
                numOfEmptyBottles += 1;
            }
        }

        return count;
    }
}
