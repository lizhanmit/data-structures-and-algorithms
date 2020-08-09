package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * Delete duplicated elements in a linked list.
 */
public class Q18B {
	
	private static class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void deleteDuplication2(Node head) {
		// if there is no or only one node in the list
		if (head == null || head.next == null) {  
			return;
		}
		
		Node pre = null;
		Node cur = head;
		
		while (cur != null && cur.next != null) {
			if (cur.value == cur.next.value) {
				int value = cur.value;
				while (cur != null && cur.value == value) {
					cur = cur.next;
				}
				
				if (pre == null) {
					pre = cur;
				} else {
					pre.next = cur;
				}
			} else {
				// the whole moves to the right
				pre = cur;
				cur = cur.next;
			}
		}
	}
	
	
	@Test
	public void testDeleteDuplication2() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(3);
		Node node5 = new Node(4);
		Node node6 = new Node(4);
		Node node7 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		deleteDuplication2(node1);
		
		StringBuilder strBuilder = new StringBuilder();
		Node node = node1;
		while (node != null) {
			strBuilder.append(Integer.toString(node.value));
			node = node.next;
		}
		
		assertEquals("125", strBuilder.toString());
	}
	
	
	/**
	 * For the scenario that elements are any type. 
	 * Different with the question in the book.
	 */
	public static <E> List<E> deleteDuplication(List<E> list) {
		Map<E, Integer> linkedHashMap = new LinkedHashMap<>();
		
		for (E e : list) {
			if (linkedHashMap.containsKey(e)) {
				linkedHashMap.put(e, linkedHashMap.get(e) + 1);
			} else {
				linkedHashMap.put(e, 1);
			}
		}
		
		List<E> newList = new LinkedList<>() ;
		
		for (Entry<E, Integer> entry : linkedHashMap.entrySet()) {
			if (entry.getValue() == 1) {
				newList.add(entry.getKey());
			}
		}
		
		return newList;
	}
	
	@Test
	public void testDeleteDuplication() {
		List<String> linkedList = new LinkedList<>();
		linkedList.add("e");
		linkedList.add("b");
		linkedList.add("f");
		linkedList.add("a");
		linkedList.add("c");
		linkedList.add("b");
		linkedList.add("f");
		
		StringBuilder strBuilder = new StringBuilder();
		for (String s : linkedList) {
			strBuilder.append(s);
		}
		assertEquals("ebfacbf", strBuilder.toString());
		
		List<String> deDupLinkedList = deleteDuplication(linkedList);
		
		StringBuilder deDupStrBuilder = new StringBuilder();
		for (String s : deDupLinkedList) {
			deDupStrBuilder.append(s);
		}
		assertEquals("eac", deDupStrBuilder.toString());
	}
	
}
