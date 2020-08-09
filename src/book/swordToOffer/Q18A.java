package book.swordToOffer;

public class Q18A {

	private static class Node<E> {
		E element;
		Node<E> next;
	}
	
	/*
	 * Time: O(1)
	 */
	public <E> void deleteNode(Node<E> head, Node<E> toBeDeleted) {
		if (head == null || toBeDeleted == null) {
			return;
		}
		
		if (head == toBeDeleted) {
			if (head.next == null) {
				head = null;
			} else {
				head = head.next;
			}
		} else if (toBeDeleted.next == null) {  // if the node to be deleted is the last node, loop
			Node node = head;
			while (node.next != toBeDeleted) {
				node = node.next;
			}
			
			node.next = null;
		} else {  // normal situation
			toBeDeleted.element = (E) toBeDeleted.next.element;
			toBeDeleted.next = toBeDeleted.next.next;
		}
	}
}
