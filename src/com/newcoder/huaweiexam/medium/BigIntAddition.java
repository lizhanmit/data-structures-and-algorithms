package com.newcoder.huaweiexam.medium;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * 描述
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * <p>
 * 输出描述：
 * 输出求和后的结果
 */
public class BigIntAddition {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s1 = scan.nextLine();
            String s2 = scan.nextLine();

            //BigInteger result = bigIntAdd(s1, s2);
            //System.out.println(result);

            bigIntAdd2(s1, s2);
        }
    }

    private static void bigIntAdd2(String s1, String s2) {
        int i = s1.length() - 1; // 索引建立在字符串末尾
        int j = s2.length() - 1; // 索引建立在字符串末尾
        boolean needCarry = false; // 是否需要进位运算，即是否需要向上一位加一
        Stack<Integer> stack = new Stack<>(); // 使用栈是因为加法从右往左算，而输出是从左往右，栈可以刚好满足需求
        while (i >= 0 || j >= 0) { // 需要两个字符串都遍历结束
            char c1 = '0';
            char c2 = '0';
            int result = 0;
            if (i >= 0) {
                c1 = s1.charAt(i);
            }
            if (j >= 0) {
                c2 = s2.charAt(j);
            }
            result = (c1 - 48) + (c2 - 48) + (needCarry ? 1 : 0);
            needCarry = false;
            if (result > 9) {
                result %= 10;
                needCarry = true; // 此时需要进位
            }
            stack.push(result); // 入栈
            i--;
            j--;
        }
        if (needCarry) {
            // 如果需要进位，表示最后计算的值大于10,所以最高位为1
            stack.push(1);
        }
        // 遍历栈，输出，由于入栈时，是低位到高位入栈，则出栈由高位向低位，满足一般的阅读顺序
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
        // 记得输出回车换行，否则编译不通过
        System.out.println();
    }

    // use BigInteger type
    private static BigInteger bigIntAdd(String s1, String s2) {
        BigInteger a = new BigInteger(s1);
        BigInteger b = new BigInteger(s2);

        return a.add(b);
    }


}
