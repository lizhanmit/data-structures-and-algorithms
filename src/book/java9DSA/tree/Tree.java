package book.java9DSA.tree;



import java.util.LinkedList;
import java.util.Stack;

import com.zhandev.datastructure.MyBinarySearchTree.Node;

public class Tree<E> {

	private Node<E> root;
	
	public Node<E> getRoot() {
		return this.root;
	}
	
	protected void traverseDepthFirst(Node<E> currentNode) {
		System.out.println(currentNode.getValue());
		currentNode.getChildren().forEach(n -> traverseDepthFirst(n));
	}
	
	protected void traverseDepthFirst() {
		traverseDepthFirst(this.getRoot());
	}
	
	public void traverseDepthFirstUsingStack() {
		Stack<Node<E>> stack = new Stack<>();
		stack.push(getRoot());
		while(stack.peek() != null) {
			Node<E> currentNode = stack.pop();
			System.out.println(currentNode.getValue());
			LinkedList<Node<E>> reverseList = new LinkedList<>();
			currentNode.getChildren().forEach(n -> reverseList.addFirst(n));
			reverseList.forEach(n -> stack.push(n));
		}
	}
	
	public static class Node<E> {
		private E value;
		private LinkedList<Node<E>> children; 
		private Tree<E> hostTree;
		private Node<E> parent;
		
		public LinkedList<Node<E>> getChildren() {
			return children;
		}
		
		public E getValue() {
			return value;
		}
	}
}
