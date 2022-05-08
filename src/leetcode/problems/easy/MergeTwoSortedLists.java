package leetcode.problems.easy;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 *
 *     两个链表的节点数目范围是 [0, 50]
 *     -100 <= Node.val <= 100
 *     l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    /**
     * Recursive approach
     * Time: O(n + m) - length of list 1 + list 2
     * Space: O(n + m) - stack space
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    private static ListNode mergeTwoSortedLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }

        if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoSortedLists(listNode1.next, listNode2);
            return listNode1;
        }

        listNode2.next = mergeTwoSortedLists(listNode1, listNode2.next);
        return listNode2;
    }

    /**
     * Iterative approach
     * Time: O(n + m) - length of list 1 + list 2
     * Space: O(1)
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    private static ListNode mergeTwoSortedLists2(ListNode listNode1, ListNode listNode2) {
        ListNode prehead = new ListNode();

        ListNode prev = prehead;

        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                prev.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                prev.next = listNode2;
                listNode2 = listNode2.next;
            }

            prev = prev.next;
        }

        prev.next = listNode1 != null ? listNode1 : listNode2;

        return prehead.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}