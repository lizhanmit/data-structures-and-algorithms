package com.newcoder.huaweiexam.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 *
 * smith     67
 *
 * jack      70
 *
 * Tom       70
 * peter     96
 *
 * 注：0代表从高到低，1代表从低到高
 *
 * 注意：本题含有多组输入数据！
 * 数据范围：人数：，数据组数：
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述：
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 * 示例1
 * 输入：
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 复制
 * 输出：
 * fang 90
 * ning 70
 * yang 50
 * 复制
 * 示例2
 * 输入：
 * 3
 * 1
 * fang 90
 * yang 50
 * ning 70
 * 3
 * 0
 * moolgouua 43
 * aebjag 87
 * b 67
 * 复制
 * 输出：
 * yang 50
 * ning 70
 * fang 90
 * aebjag 87
 * b 67
 * moolgouua 43
 * 复制
 * 说明：
 * 第一组用例:
 * 3
 * 1
 * fang 90
 * yang 50
 * ning 70
 * 升序排序为：
 * yang 50
 * ning 70
 * fang 90
 * 第二组降序为:
 * aebjag 87
 * b 67
 * moolgouua 43
 */
public class SortTranscript {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int sortFlag = in.nextInt();

            List<Student> list = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                Student std = new Student(in.next(), in.nextInt());
                list.add(std);
            }

            List<Student> sortedList = sortTranscript(list, sortFlag);
            sortedList.forEach(s -> System.out.println(s.getName() + " " + s.getGrade()));
        }
    }

    private static List<Student> sortTranscript(List<Student> list, int sortFlag) {
        if (sortFlag == 0) {  // descending
            return list.stream().sorted((std1, std2) -> std2.getGrade() - std1.getGrade()).collect(Collectors.toList());
        } else if (sortFlag == 1) {  // ascending
            return list.stream().sorted((std1, std2) -> std1.getGrade() - std2.getGrade()).collect(Collectors.toList());
        }

        return list;
    }
}

class Student {
    private String name;
    private int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
