package com.zhandev.datastructure;

public class MyBinarySearchTree {

	public static void main(String[] args) {
		MyBinarySearchTree bst = new MyBinarySearchTree();
		Node rootNode = bst.new Node(4);
		rootNode.insert(2);
		rootNode.insert(6);
		rootNode.insert(8);
		rootNode.printInOrder();
		System.out.println(rootNode.contains(4));
		System.out.println(rootNode.contains(3));
	} 
	
	public class Node {
		Node left, right; 
		int data; 
		
		public Node(int data) {
			this.data = data; 
		}
		
		/**
		 * Insert a node. 
		 * @param value  The value of the node to be inserted.
		 */
		public void insert(int value) {
			if (value <= data) {
				if (left == null) {
					left = new Node(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new Node(value);
				} else {
					right.insert(value);
				}
			}
		}
		
		/**
		 * Check if the value is in the tree.
		 * @param value
		 * @return
		 */
		public boolean contains(int value) {
			if (value == data) {
				return true;
			} else if (value < data) {
				if (left == null) {
					return false;
				} else {
					return left.contains(value);
				}
			} else {
				if (right == null) {
					return false;
				} else {
					return right.contains(value);
				}
			}
		}
		
		/**
		 * Print tree with in-order traversal. 
		 * in-order: left -> parent -> right
		 */
		public void printInOrder() {
			/*
			 * Change the order of these three for pre-order and post-order traversal.
			 */
			
			if (left != null) {
				left.printInOrder();
			}
			
			System.out.println(data);
			
			if (right != null) {
				right.printInOrder();
			}
		}
	}
}
