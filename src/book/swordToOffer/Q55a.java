package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

/**
 * Get the depth of a binary tree.
 */
public class Q55a {

	static class BinaryTreeNode<E> {
		E element;
		BinaryTreeNode<E> leftNode;
		BinaryTreeNode<E> rightNode;
		
		public BinaryTreeNode(E e) {
			element = e;
		}
		
		public void setLeftNode(BinaryTreeNode<E> leftNode) {
			this.leftNode = leftNode;
		}
		
		public void setRightNode(BinaryTreeNode<E> rightNode) {
			this.rightNode = rightNode;
		}
	}
	
	/*
	 * Get depth using recursive method.
	 */
	public static <E> int depthRecursive(BinaryTreeNode<E> root) {
		if (root == null) {
			return 0;
		}
		
		int leftDepth = depthRecursive(root.leftNode);
		int rightDepth = depthRecursive(root.rightNode);
		
		return Math.max(leftDepth, rightDepth) + 1; 
		// or return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
	}
	
	/*
	 * Get depth using level order traversal.
	 */
	public static <E> int depth(BinaryTreeNode<E> root) {
		if (root == null) {
			return 0;
		}
		
		LinkedList<BinaryTreeNode<E>> queue = new LinkedList<>();
		int depth = 0;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				BinaryTreeNode<E> node = queue.poll();
				if (node.leftNode != null && node.leftNode.element != null) {
					queue.offer(node.leftNode);
				}
				if (node.rightNode != null && node.rightNode.element != null) {
					queue.offer(node.rightNode);
				}
			}
			depth++;
		}
		return depth;
	}
	
	@Test
	public void testDepth() {
		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("root");
		BinaryTreeNode<String> left11 = new BinaryTreeNode<>("left11");
		BinaryTreeNode<String> right11 = new BinaryTreeNode<>("right11");
		BinaryTreeNode<String> left21 = new BinaryTreeNode<>("left21");
		BinaryTreeNode<String> right21 = new BinaryTreeNode<>("right21");
		BinaryTreeNode<String> left22 = new BinaryTreeNode<>("left22");
		BinaryTreeNode<String> right22 = new BinaryTreeNode<>("right22");
		
		rootNode.setLeftNode(left11);
		rootNode.setRightNode(right11);
		left11.setLeftNode(left21);
		left11.setRightNode(right21);
		right11.setLeftNode(left22);
		right11.setRightNode(right22);
		
		assertEquals(depth(rootNode), 3);
		assertEquals(depthRecursive(rootNode), 3);
	}
}
