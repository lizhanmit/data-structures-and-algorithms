package book.DSAInJava.linkedList;

public class DoublyLinkedList<E> {
	/*
	 * nested Node class
	 */
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	// NOTE here, different with singly linked list
	// using header and trailer sentinel instead of head and tail
	private Node<E> header;  // header sentinel
	private Node<E> trailer;  // trailer sentinel
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if (size == 0) {
			return null;
		}
		return header.getNext().getElement();
	}
	
	public E last() {
		if (size == 0) {
			return null;
		}
		return trailer.getPrev().getElement();
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> succcessor) {
		Node<E> newest = new Node<>(e, predecessor, succcessor);
		predecessor.setNext(newest);
		succcessor.setPrev(newest);
		size++;
	}
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	private E remove(Node<E> n) {
		Node<E> predecessor = n.getPrev();
		Node<E> successor = n.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return n.getElement();
	}
	
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		return remove(header.getNext());
	}
	
	public E removeLast() {
		if (size == 0) {
			return null;
		}
		return remove(trailer.getPrev());
	}
}
