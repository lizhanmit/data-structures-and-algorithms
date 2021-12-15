package com.newcoder.huaweiexam.medium;


import java.util.*;

/**
 * 描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 * 数据范围：字符串长度满足
 * <p>
 * 输入描述：
 * 一个只包含小写英文字母和数字的字符串。
 * <p>
 * 输出描述：
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 */
public class CountCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String input = in.nextLine();

            //strAfterCountingCharacters(input);

            strAfterCountingCharacters2(input);
        }
    }

    private static void strAfterCountingCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        List<Map.Entry> list = new ArrayList<>(map.entrySet());

        list.stream().sorted((e1, e2) -> {
            if (e1.getValue() != e2.getValue()) {
                return (int) e2.getValue() - (int) e1.getValue();  // NOTE, e2 - e1 because of descending
            } else {
                return (char) (e1.getKey()) - (char) (e2.getKey());  // NOTE, e1 - e2 because of ascending
            }
        }).forEach(entry -> System.out.print(entry.getKey()));

        System.out.println();
    }

    private static void strAfterCountingCharacters2(String str) {
        char[] chars = str.toCharArray();
        int[] chArray = new int[129];
        //字符对应ascll码值下标元素自增来统计数量
        for (char i : chars) {
            chArray[(int) i]++;
        }

        int max = 0;

        //找出字符数量最多的ascll码值
        for (int i = 0; i < chArray.length; i++) {
            if (max < chArray[i]) {
                max = chArray[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        //按数量从大到小添加到可变字符序列sb
        while (max != 0) {
            //遍历找到与当前max相等的字符
            for (int i = 0; i < chArray.length; i++) {
                if (chArray[i] == max) {
                    sb.append((char) i);
                }

            }
            //max减1 进入下一轮遍历
            max--;
        }

        System.out.println(sb.toString());
    }
}
