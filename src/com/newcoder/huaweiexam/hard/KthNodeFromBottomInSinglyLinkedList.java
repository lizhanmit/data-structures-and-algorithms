package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 *
 * 链表结点定义如下：
 *
 * struct ListNode
 *
 * {
 *
 * int       m_nKey;
 *
 * ListNode* m_pNext;
 *
 * };
 *
 *
 *
 * 正常返回倒数第k个结点指针，异常返回空指针
 *
 * 数据范围：链表长度满足  ，  ，链表中数据满足
 *
 * 本题有多组样例输入。
 *
 *
 * 输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 *
 * 输出描述：
 * 输出一个整数
 *
 * 示例1
 * 输入：
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 复制
 * 输出：
 * 5
 */
public class KthNodeFromBottomInSinglyLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNext()) {
            int numOfNodes = in.nextInt();
            ListNode head = new ListNode(-1);
            ListNode tempNode = head;

            for (int i = 0; i < numOfNodes; i++) {
                ListNode node = new ListNode(in.nextInt());
                tempNode.next = node;
                tempNode = tempNode.next;
            }

            int k = in.nextInt();

            ListNode kthNodeFromBottom = kthNodeFromBottom(head, k);

            if (kthNodeFromBottom != null) {
                System.out.println(kthNodeFromBottom.value);
            } else {
                System.out.println(0);
            }
        }
    }

    // use fast and slow point
    private static ListNode kthNodeFromBottom(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        // fast point moves k steps beforehand
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return fast;
            }

            fast = fast.next;
        }

        // fast and slow point moves together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
