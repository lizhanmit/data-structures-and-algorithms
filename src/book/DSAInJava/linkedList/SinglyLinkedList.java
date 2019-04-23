package book.DSAInJava.linkedList;

public class SinglyLinkedList<E> {
	
	/*
	 * nested Node class
	 */
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) {
			tail = head; 
		}
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (size == 0) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		E first = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return first;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		SinglyLinkedList other = (SinglyLinkedList) obj;
		if (this.size != other.size) {
			return false;
		}
		Node walkA = this.head;
		Node walkB = other.head;
		
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement())) {
				return false;
			}
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
}
