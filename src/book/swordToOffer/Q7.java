package book.swordToOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Reconstruct a binary tree according to its pre-order and in-order traversal result, 
 * and return the root node.
 * What you return is not a pure root, but root linking with its left node and right node.
 */
public class Q7 {

	private static class BinaryTreeNode {
		int value;
		BinaryTreeNode leftNode;
		BinaryTreeNode rightNode;
		
		public BinaryTreeNode(int v) {
			this.value = v;
		}
	}
	
	public static BinaryTreeNode reconstructBinaryTree(int[] preOrder, int[] inOrder) {
		if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
			return null;
		}
		
		BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
		int leftNodesNum = 0;
		int rightNodesNum = 0;
		
		for (int i = 0; i < inOrder.length; i++) {
			if (root.value == inOrder[i]) {
				leftNodesNum = i;
				rightNodesNum = inOrder.length - i -1;
				break;
			}
		}
		
		int[] leftTreePreOrder = Arrays.copyOfRange(preOrder, 1, leftNodesNum + 1);
		int[] leftTreeInOrder = Arrays.copyOfRange(inOrder, 0, leftNodesNum);
		BinaryTreeNode leftTreeRoot = reconstructBinaryTree(leftTreePreOrder, leftTreeInOrder);
		
		int[] rightTreePreOrder = Arrays.copyOfRange(preOrder, leftNodesNum + 1, preOrder.length);
		int[] rightTreeInOrder = Arrays.copyOfRange(inOrder, leftNodesNum + 1, inOrder.length);
		BinaryTreeNode rightTreeRoot = reconstructBinaryTree(rightTreePreOrder, rightTreeInOrder);

		root.leftNode = leftTreeRoot;
		root.rightNode = rightTreeRoot;
		
		return root;
	}
	
	@Test
	public void testReconstructBinaryTree() {
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};
		BinaryTreeNode root = reconstructBinaryTree(preOrder, inOrder);
		printByLevelOrder(root);
		printByPostOrder(root);  // 7 4 2 5 8 6 3 1 
	}
	
	public static void printByLevelOrder(BinaryTreeNode root) {
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
			System.out.print(currentNode.value + " ");
			
			if (currentNode.leftNode != null) {
				queue.add(currentNode.leftNode);
				nextLayerLast = currentNode.leftNode;
			}
			
			if (currentNode.rightNode != null) {
				queue.add(currentNode.rightNode);
				nextLayerLast = currentNode.rightNode;
			}
			
			if (currentLayerLast == currentNode) {
				System.out.println();
				// move the current layer to the next layer
				currentLayerLast = nextLayerLast;
			}
		}
	}
	
	public static void printByPostOrder(BinaryTreeNode node) {
		if (node != null) {
			printByPostOrder(node.leftNode);
			printByPostOrder(node.rightNode);
			System.out.print(node.value + " ");
		}
	}
}
