package com.zhandev.datastructure.printBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBinaryTreeDemo {
	
	/*
	 * parentNode -> leftNode -> rightNode
	 */
	public static void preOrder(BinaryTreeNode node) {
		if (node != null) {
			System.out.println(node.getValue());
			preOrder(node.getLeftNode());
			preOrder(node.getRightNode());
		}
	}
	
	public static void preOrderNonRecursive(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				System.out.println(node.getValue());
				stack.push(node);
				node = node.getLeftNode();
			}
			
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.getRightNode();
			}
		}
	}
	
	
	/*
	 * leftNode -> parentNode -> rightNode
	 */
	public static void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.getLeftNode());
			System.out.println(node.getValue());
			inOrder(node.getRightNode());
		}
	}
	
	
	public static void inOrderNonRecursive(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.getLeftNode();
			}
			
			if (!stack.isEmpty()) {
				node = stack.pop();
				System.out.println(node.getValue());
				node = node.getRightNode();
			}
		}
	}

	
	/*
	 * leftNode -> rightNode -> parentNode
	 */
	public static void postOrder(BinaryTreeNode node) {
		if (node != null) {
			postOrder(node.getLeftNode());
			postOrder(node.getRightNode());
			System.out.println(node.getValue());
		}
	}
	
	public static void postOrderNonRecursive(BinaryTreeNode node) {
		
	}
	
	/*
	 * level by level
	 */
	public static void levelOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		
		// used to store nodes
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		
		BinaryTreeNode currentLayerLast = root;
		BinaryTreeNode nextLayerLast = null;
		
		queue.add(root);
	
		while(!queue.isEmpty()) {
			BinaryTreeNode currentNode = queue.poll();
			System.out.print(currentNode.getValue() + " ");
			
			if (currentNode.hasLeftNode()) {
				queue.add(currentNode.getLeftNode());
				nextLayerLast = currentNode.getLeftNode();
			}
			
			if (currentNode.hasRightNode()) {
				queue.add(currentNode.getRightNode());
				nextLayerLast = currentNode.getRightNode();
			}
			
			if (currentLayerLast == currentNode) {
				System.out.println();
				// move the current layer to the next layer
				currentLayerLast = nextLayerLast;
			}
		}
	}
	
	public static void levelOrder2(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		
		// enqueue the node in the first loop
		// dequeue and print the node in the next loop
		while (!queue.isEmpty()) {
			BinaryTreeNode currentNode = queue.poll();
			System.out.println(currentNode.getValue());
			
			if (currentNode.hasLeftNode()) {
				queue.add(currentNode.getLeftNode());
			}
			
			if (currentNode.hasRightNode()) {
				queue.add(currentNode.getRightNode());
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode rootNode = new BinaryTreeNode("root");
		BinaryTreeNode left11 = new BinaryTreeNode("left11");
		BinaryTreeNode right11 = new BinaryTreeNode("right11");
		BinaryTreeNode left21 = new BinaryTreeNode("left21");
		BinaryTreeNode right21 = new BinaryTreeNode("right21");
		BinaryTreeNode left22 = new BinaryTreeNode("left22");
		BinaryTreeNode right22 = new BinaryTreeNode("right22");
		
		rootNode.setLeftNode(left11);
		rootNode.setRightNode(right11);
		left11.setLeftNode(left21);
		left11.setRightNode(right21);
		right11.setLeftNode(left22);
		right11.setRightNode(right22);
		
		System.out.println("=== levelOrder ===");
		levelOrder(rootNode);
		
		System.out.println("=== levelOrder2 ===");
		levelOrder2(rootNode);
		
		System.out.println("=== preOrder ===");
		preOrder(rootNode);
		
		System.out.println("=== preOrderNonRecursive ===");
		preOrderNonRecursive(rootNode);
		
		System.out.println("=== inOrder ===");
		inOrder(rootNode);
		
		System.out.println("=== inOrderNonRecursive ===");
		inOrderNonRecursive(rootNode);
		
		System.out.println("=== postOrder ===");
		postOrder(rootNode);
		
		System.out.println("=== postOrderNonRecursive ===");
		postOrderNonRecursive(rootNode);
	}
}
