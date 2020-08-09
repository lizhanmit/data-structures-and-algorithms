package leetcode.explore.linkedList;

public class ReverseList {

	public class ListNode {
		int val; 
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	/*
	 * iteration method
	 */
	public ListNode reverseList(ListNode head) {
		ListNode prev = null; 
		ListNode curr = head; 
		
		while (curr != null) {
			ListNode tempNode = curr.next;
			curr.next = prev; 
			prev = curr; 
			curr = tempNode;
		}
		
		return prev;
    }
}
