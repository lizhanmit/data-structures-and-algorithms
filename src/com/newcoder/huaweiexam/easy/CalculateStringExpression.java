package com.newcoder.huaweiexam.easy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

/**
 * 描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * <p>
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 * <p>
 * 数据范围：运算过程中和最终结果均满足  ，即只进行整型运算，确保输入的表达式合法
 * 输入描述：
 * 输入算术表达式
 * <p>
 * 输出描述：
 * 计算出结果值
 */
public class CalculateStringExpression {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        //int result = calculateStringExpression(str);
        int result = calculateStringExpression2(str);

        System.out.println(result);
    }

    // use js scriptEngine eval()
    private static int calculateStringExpression(String str) {
        int result = 0;

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        try {
            result = (int) scriptEngine.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static int calculateStringExpression2(String str) {
        // 优先级maps
        Map<Character, Integer> maps = new HashMap<>();
        maps.put('+', 1);
        maps.put('-', 1);
        maps.put('*', 2);
        maps.put('/', 2);
        maps.put('%', 2);
        maps.put('^', 3);

        // 双栈法
        // 数据栈
        Deque<Integer> nums = new LinkedList<>();
        nums.push(0);
        // 操作栈
        Deque<Character> ops = new LinkedList<>();
        // 预处理
        str = str.replaceAll(" ", "");
        str = str.replaceAll("\\(-", "\\(0-");
        str = str.replaceAll("\\(+", "\\(0+");
        if (str.charAt(0) == '-') { // 特判首字符是负数
            str = '0' + str;
        }
        // 转换成字符数组
        char[] chars = str.toCharArray();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                ops.push(chars[i]);
            } else if (chars[i] == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peek() == '(') {
                        ops.pop();
                        break;
                    } else {
                        calc(nums, ops);
                    }
                }

            } else {
                if (isNumber(chars[i])) {
                    // 当前遇到的是数字
                    int j = 0;
                    int k = i;
                    while (k < n && isNumber(chars[k])) {
                        j = j * 10 + (chars[k] - '0');
                        k++;
                    }
                    nums.push(j);
                    i = k - 1;
                } else {
                    // 当前遇到的是加减乘除
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        if (maps.get(ops.peek()) >= maps.get(chars[i])) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.push(chars[i]);
                }
            }
        }
        while (!ops.isEmpty() && ops.peek() != '(') {
            calc(nums, ops);
        }
        return nums.peek();
    }

    // 判断是否是数字
    public static boolean isNumber(char cur) {
        return Character.isDigit(cur);
    }

    //  进行计算
    public static void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (ops.isEmpty()) return;
        if (nums.isEmpty() || nums.size() < 2) return;
        int b = nums.pop();
        int a = nums.pop();
        int op = ops.pop();
        int res = 0;
        if (op == '+') {
            res = a + b;
        } else if (op == '-') {
            res = a - b;
        } else if (op == '*') {
            res = a * b;
        } else if (op == '/') {
            res = a / b;
        } else if (op == '^') {
            res = (int) Math.pow(a, b);
        } else if (op == '%') {
            res = a % b;
        }
        nums.push(res);
    }
}
