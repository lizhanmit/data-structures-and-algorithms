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
	
	// hard to understand
	public static void preOrderNonRecursive(BinaryTreeNode node) {
		if (node == null) return;
		
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
	
	// leetCode, easy to understand 
	// O(n) time, O(n) space
	public static void preOrderNonRecursive2(BinaryTreeNode node) {
		if (node == null) return;
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		
		stack.push(node);
		
		while (!stack.isEmpty()) {
			BinaryTreeNode cur = stack.pop();
			System.out.println(cur.getValue());
			
			if (cur.hasRightNode()) {
				stack.push(cur.getRightNode());
			}
			
			if (cur.hasLeftNode()) {
				stack.push(cur.getLeftNode());
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
	
	// leetCode, hard to understand
	public static void inOrderNonRecursive(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.getLeftNode();
			}
			
			node = stack.pop();
			System.out.println(node.getValue());
			node = node.getRightNode();
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
	
	// leetCode
	public static void postOrderNonRecursive(BinaryTreeNode node) {
		if (node == null) return;
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		
		Stack<BinaryTreeNode> resultStack = new Stack<>();
		
		stack.push(node);
		while (!stack.isEmpty()) {
			BinaryTreeNode cur = stack.pop();
			resultStack.push(cur);
			
			if (cur.hasLeftNode()) {
				stack.push(cur.getLeftNode());
			}
			
			if (cur.hasRightNode()) {
				stack.push(cur.getRightNode());
			}
		}
		
		while (!resultStack.isEmpty()) {
			System.out.println(resultStack.pop().getValue());
		}
	}
	
	/*
	 * level by level
	 */
	// recommend, easy to understand
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
	
	// bad because currentLayerLast and nextLayerLast are redundant
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
	
	public static void main(String[] args) {
		BinaryTreeNode rootNode = new BinaryTreeNode("a");
		BinaryTreeNode b = new BinaryTreeNode("b");
		BinaryTreeNode c = new BinaryTreeNode("c");
		BinaryTreeNode d = new BinaryTreeNode("d");
		BinaryTreeNode e = new BinaryTreeNode("e");
		BinaryTreeNode f = new BinaryTreeNode("f");
		BinaryTreeNode g = new BinaryTreeNode("g");
		
		rootNode.setLeftNode(b);
		rootNode.setRightNode(c);
		b.setLeftNode(d);
		b.setRightNode(e);
		c.setLeftNode(f);
		c.setRightNode(g);
		
		System.out.println("=== levelOrder ===");
		levelOrder(rootNode);
		
		System.out.println("=== levelOrder2 ===");
		levelOrder2(rootNode);
		
		System.out.println("=== preOrder ===");
		preOrder(rootNode);
		
		System.out.println("=== preOrderNonRecursive ===");
		preOrderNonRecursive(rootNode);
		
		System.out.println("=== preOrderNonRecursive2 ===");
		preOrderNonRecursive2(rootNode);
		
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
