package book.swordToOffer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Given a node in a binary tree, find the next node of in-order traversal.
 */
public class Q8 {

	private static class BinaryTreeNode<E> {
		E element;
		BinaryTreeNode<E> parentNode;
		BinaryTreeNode<E> leftNode;
		BinaryTreeNode<E> rightNode;
		
		public BinaryTreeNode(E e) {
			this.element = e;
		}
		
		public void setParentNode(BinaryTreeNode<E> parentNode) {
			this.parentNode = parentNode;
		}
		
		public void setLeftNode(BinaryTreeNode<E> leftNode) {
			this.leftNode = leftNode;
		}
		
		public void setRightNode(BinaryTreeNode<E> rightNode) {
			this.rightNode = rightNode;
		}
	}
	
	public static <E> BinaryTreeNode<E> nextNodeOfInOrderTraversal(BinaryTreeNode<E> node) {
		if (node == null) {
			return null;
		}
		
		if (node.rightNode != null) {
			BinaryTreeNode<E> mostLeftNode = node.rightNode;
			while (mostLeftNode.leftNode != null) {
				mostLeftNode = mostLeftNode.leftNode;
			}
			return mostLeftNode;
		}
		
		if (node.parentNode.leftNode == node) {
			return node.parentNode;
		}
		
		
		BinaryTreeNode<E> tempNode = node.parentNode;
		while (tempNode.parentNode != null) {
			if (tempNode.parentNode.leftNode == tempNode) {
				return tempNode.parentNode;
			}
			tempNode = tempNode.parentNode;
		}
		return null;
	}
	
	@Test
	public void testNextNodeOfInOrderTraversal() {
		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("root");
		BinaryTreeNode<String> left11 = new BinaryTreeNode<>("left11");
		BinaryTreeNode<String> right11 = new BinaryTreeNode<>("right11");
		BinaryTreeNode<String> left21 = new BinaryTreeNode<>("left21");
		BinaryTreeNode<String> right21 = new BinaryTreeNode<>("right21");
		BinaryTreeNode<String> left22 = new BinaryTreeNode<>("left22");
		BinaryTreeNode<String> right22 = new BinaryTreeNode<>("right22");
		
		rootNode.setLeftNode(left11);
		rootNode.setRightNode(right11);
		left11.setParentNode(rootNode);
		right11.setParentNode(rootNode);
		
		left11.setLeftNode(left21);
		left11.setRightNode(right21);
		left21.setParentNode(left11);
		right21.setParentNode(left11);
		
		right11.setLeftNode(left22);
		right11.setRightNode(right22);
		left22.setParentNode(right11);
		right22.setParentNode(right11);
		
		assertEquals(nextNodeOfInOrderTraversal(null), null);
		assertEquals(nextNodeOfInOrderTraversal(rootNode), left22);
		assertEquals(nextNodeOfInOrderTraversal(left11), right21);
		assertEquals(nextNodeOfInOrderTraversal(right11), right22);
		assertEquals(nextNodeOfInOrderTraversal(left21), left11);
		assertEquals(nextNodeOfInOrderTraversal(right21), rootNode);
		assertEquals(nextNodeOfInOrderTraversal(left22), right11);
		assertEquals(nextNodeOfInOrderTraversal(right22), null);
	}
}
