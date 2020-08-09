package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import book.swordToOffer.Q55a.BinaryTreeNode;

/**
 * Check if a binary tree is balanced.
 */
public class Q55b {

	/*
	 * Check if a binary tree is balanced using recursive method.
	 * not good due to repeated traversal
	 */
	public static <E> boolean isBalancedRecursive(Q55a.BinaryTreeNode<E> root) {
		if (root == null || root.element == null) {
			return true;
		}
		
		int leftDepth = Q55a.depth(root.leftNode);
		int rightDepth = Q55a.depth(root.rightNode);
		
		if (Math.abs(leftDepth - rightDepth) > 1) {
			return false;
		}
		return isBalancedRecursive(root.leftNode) && isBalancedRecursive(root.rightNode);
	}
	
	/*
	 * recommended
	 */
	public static <E> boolean isBalanced(Q55a.BinaryTreeNode<E> root) {
		if (root == null || root.element == null) {
			return true;
		}
		return depth(root) > -1;
	}
	
	private static <E> int depth(Q55a.BinaryTreeNode<E> root) {
		if (root == null || root.element == null) {
			return 0;
		}
		
		int leftDepth = depth(root.leftNode);
		int rightDepth = depth(root.rightNode);
		
		return leftDepth >= 0 && rightDepth >= 0 && Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
	}
	
	/*
	 * Check if a binary tree is balanced using post-order traversal method.
	 * Estimate child node first, then parent node, finally root node. Traverse only once.
	 * If any child tree is not balanced, return false.
	 * recommended
	 */
	public static <E> boolean isBalancedUsingPostOrderTraversal(Q55a.BinaryTreeNode<E> root, Depth depth) {
		if (root == null || root.element == null) {
			depth.value = 0;
			return true;
		}
		
		Depth leftDepth = new Depth();
		Depth rightDepth = new Depth();
		
		if (isBalancedUsingPostOrderTraversal(root.leftNode, leftDepth) && isBalancedUsingPostOrderTraversal(root.rightNode, rightDepth)) {
			if (Math.abs(leftDepth.value - rightDepth.value) <= 1) {
				depth.value = (leftDepth.value > rightDepth.value ? leftDepth.value : rightDepth.value) + 1;
				return true;
			}
		}
		return false;
	}
	
	private static class Depth {
		int value;
	}
	
	
	@Test
	public void testIsBalanced() {
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
		
		assertEquals(isBalancedRecursive(rootNode), true);
		assertEquals(isBalanced(rootNode), true);
		assertEquals(isBalancedUsingPostOrderTraversal(rootNode, new Depth()), true);
		
		rootNode.setLeftNode(left11);
		left11.setLeftNode(right11);
		right11.setLeftNode(left21);
		left21.setLeftNode(right21);
		rootNode.setRightNode(left22);
		
		assertEquals(isBalancedRecursive(rootNode), false);
		assertEquals(isBalanced(rootNode), false);
		assertEquals(isBalancedUsingPostOrderTraversal(rootNode, new Depth()), false);

	}
}
