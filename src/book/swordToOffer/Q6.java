package book.swordToOffer;

import java.util.Stack;

import org.junit.Test;

public class Q6 {

	private static class Node {
		int element;
		Node next;
		
		public Node(int e) {
			element = e;
		}
		
		public int getElement() {
			return element;
		}
		
		public void setNext(Node n) {
			next = n;
		}
	}
	
	/*
	 * recommended
	 * more robust
	 */
	public static void printLinkedListReversely(Node head) {
		if (head != null) {
			Stack<Integer> stack = new Stack<>();
			Node node = head;
			stack.push(head.getElement());
			
			// push the linked list into stack
			while (node.next != null) {
				stack.push(node.next.getElement());
				node = node.next;
			}
			
			// print linked list out of stack
			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
		}
	}
	
	/*
	 * If size of the linked list is very big, do not use recursion because of:
	 * potential StackOverFlowError
	 * low performance and efficiency
	 */
	public static void printLinkedListReverselyRecursively(Node head) {
		if (head != null) {
			Node node = head;
			printLinkedListReverselyRecursively(node.next);
			System.out.println(node.getElement());
		}
	}
	
	
	@Test
	public void testPrintLinkedListReversely() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.setNext(node2);
		node2.setNext(node3);
		printLinkedListReversely(node1);
		printLinkedListReverselyRecursively(node1);
	}
}
