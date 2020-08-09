package book.DSAInJava.linkedList;

public class CircularlyLinkedList<E> {
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

	private Node<E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() {
		
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
		
		return tail.getNext().getElement();
	}

	public E last() {
		if (size == 0) {
			return null;
		}
		
		return tail.getElement();
	}
	
	public void addFirst(E e) {
		if (size == 0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);  // link to itself circularly if there is only one element
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		Node<E> first = tail.getNext();
		if (tail == first) {
			tail = null;
		} else {
			tail.setNext(first.getNext());
		}
		size--;
		return first.getElement();
	}
	
	public void rotate() {
		if (size != 0) {  // or if (tail != null)
			tail = tail.getNext();
		}
	}
}
