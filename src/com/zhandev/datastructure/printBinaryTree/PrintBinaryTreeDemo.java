package com.zhandev.datastructure.printBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print binary tree layer by layer.
 *
 */
public class PrintBinaryTreeDemo {

	
	public static void printBinaryTree(BinaryTreeNode root) {
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
		
		printBinaryTree(rootNode);
	}
}
