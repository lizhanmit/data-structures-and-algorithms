package com.zhandev.datastructure.printBinaryTree;

public class BinaryTreeNode {

	private String value;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	
	
	public BinaryTreeNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public boolean hasLeftNode() {
		if (this.leftNode == null || this.leftNode.getValue() == null) {
			return false;
		}
		return true;
	}
	
	public boolean hasRightNode() {
		if (this.rightNode == null || this.rightNode.getValue() == null) {
			return false;
		}
		return true;
	}
}
