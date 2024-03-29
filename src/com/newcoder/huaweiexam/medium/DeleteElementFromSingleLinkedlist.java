package com.newcoder.huaweiexam.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 * <p>
 * 链表的值不能重复。
 * <p>
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 * <p>
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 * <p>
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 * <p>
 * 4 5表示为
 * 5->4
 * 链表为2->3->1->5->4
 * <p>
 * 7 2表示为
 * 2->7
 * 链表为2->7->3->1->5->4
 * <p>
 * 最后的链表的顺序为 2 7 3 1 5 4
 * <p>
 * 最后一个参数为2，表示要删掉节点为2的值
 * 删除 结点 2
 * <p>
 * 则结果为 7 3 1 5 4
 * <p>
 * 数据范围：链表长度满足  ，节点中的值满足
 * <p>
 * 测试用例保证输入合法
 * <p>
 * <p>
 * 输入描述：
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 * <p>
 * 输出描述：
 * 输出一行
 * 输出删除结点后的序列，每个数后都要加空格
 */
public class DeleteElementFromSingleLinkedlist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int total = sc.nextInt();
            int head = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            list.add(head);
            for (int i = 0; i < total - 1; i++) {
                int value = sc.nextInt();
                int target = sc.nextInt();
                list.add(list.indexOf(target) + 1, value);
            }

            int remove = sc.nextInt();
            list.remove(list.indexOf(remove));
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
