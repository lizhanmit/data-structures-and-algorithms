package com.newcoder.huaweiexam.medium;

import java.util.Scanner;
import java.util.Stack;

/**
 * 描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 * <p>
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * <p>
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * <p>
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * <p>
 * 本题含有多组样例输入！
 * 数据范围：数据组数：，矩阵个数：，行列数：
 * 进阶：时间复杂度：，空间复杂度：
 * <p>
 * 输入描述：
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 * <p>
 * 输出描述：
 * 输出需要进行的乘法次数
 */
public class MatrixMultiplicationComputation {

    // [m,n] x [n,p] 共会有n*p*m次乘法运算，运算后的矩阵为 [m,p]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] num = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] arr = sc.nextLine().split(" ");
                num[i][0] = Integer.parseInt(arr[0]);
                num[i][1] = Integer.parseInt(arr[1]);
            }
            String msg = sc.nextLine();
            Stack<Integer> z = new Stack<>();
            int count = 0;
            for (int j = 0; j < msg.length(); j++) {
                char tmp = msg.charAt(j);
                if (tmp == '(') {
                    continue;
                } else if (tmp == ')') {
                    int cc = z.pop();
                    int cr = z.pop();
                    int bc = z.pop();
                    int br = z.pop();
                    count += br * cc * bc;
                    z.push(br);
                    z.push(cc);

                } else {
                    int index = tmp - 'A';
                    z.push(num[index][0]);
                    z.push(num[index][1]);
                }
            }
            System.out.println(count);
        }
    }
}
