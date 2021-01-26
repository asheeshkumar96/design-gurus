package com.depthFirstSearch;

public class SumOfPathNumbers {

	public static int findSumOfPathNumbers(TreeNode root) {
		return findSumOfPathNumbersRecursively(root, 0);
	}

	private static int findSumOfPathNumbersRecursively(TreeNode currentNode, int currentSum) {
		if (currentNode == null)
			return 0;
		
		System.out.println("before adding new digit, currentSum = " + currentSum);
		currentSum = currentSum * 10 + currentNode.val;
		System.out.println("after adding new digit, currentSum = " + currentSum);
		
		if(currentNode.left == null && currentNode.right == null) {
			return currentSum;
		}
		
		return findSumOfPathNumbersRecursively(currentNode.left, currentSum)
					+ findSumOfPathNumbersRecursively(currentNode.right, currentSum);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}
}
