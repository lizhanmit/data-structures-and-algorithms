package com.zhandev.datastructure;

public class MySimpleLinkedList {

	public static void main(String[] args) {
		MySimpleLinkedList simplelinkedList = new MySimpleLinkedList();
		simplelinkedList.append(0);
		simplelinkedList.append(1);
		simplelinkedList.append(2);
		simplelinkedList.display(simplelinkedList.head);
		System.out.println("===");
		
		simplelinkedList.prepend(-1);
		simplelinkedList.prepend(-2);
		simplelinkedList.display(simplelinkedList.head);
		System.out.println("===");
		
		simplelinkedList.deleteWithValue(0);
		simplelinkedList.display(simplelinkedList.head);
	}
	
	Node head; 
	
	public void append(int data) {
		if (head == null) { // if the linked list is empty
			head = new Node(data);
			return;
		}
		
		Node current = head; 
		while (current.next != null) { // current node is not the last node
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int data) {
		if (head == null) return;
		
		if (head.getData() == data) { // if head is going to be deleted
			head = head.next;
			return;
		}
		
		Node current = head;
		while (current.next != null) { 
			if (current.next.getData() == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public void display(Node node) {
		if (node == null) {
			return;
		}

		Node current = node;
		while (current != null) {
			System.out.println(current.getData());
			current = current.next;
		}
	}
	
	public class Node {
		Node next;
		private int data; 
		
		public Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return this.data;
		}
	}
}
