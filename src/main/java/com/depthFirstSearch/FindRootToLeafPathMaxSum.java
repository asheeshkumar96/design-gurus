package com.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;


/**
 * Problem 2: Given a binary tree, find the root-to-leaf path with the maximum sum.

Solution: We need to find the path with the maximum sum. As we traverse all paths, we can keep track of the path with the maximum sum.
 *
 */
public class FindRootToLeafPathMaxSum {
	
	static int maxSum = Integer.MIN_VALUE; 
	
	static List<Integer> rootToLeafWithMaxSum;
	
	public static List<Integer> findRootToLeafPathWithMaxSum(TreeNode root) {
		// List<Integer> rootToLeafWithMaxSum = new ArrayList<>(1);
		List<Integer> currentPath = new ArrayList<>();
		int currentSum = 0;
		// int maxSum = 0;
		findRootToLeafPathWithMaxSumRecursive(root, currentSum, currentPath);
		return rootToLeafWithMaxSum;
	}

	// Can it be solved without using global variables
	private static void findRootToLeafPathWithMaxSumRecursive(TreeNode currentNode, int currentSum,
			List<Integer> currentPath) {
		if (currentNode == null)
			return;

		currentPath.add(currentNode.val);
		currentSum += currentNode.val;

		if (currentNode.left == null && currentNode.right == null && currentSum > maxSum) {
			maxSum = currentSum;
			rootToLeafWithMaxSum = new ArrayList<Integer>(currentPath);
		} else {
			findRootToLeafPathWithMaxSumRecursive(currentNode.left, currentSum, currentPath);
			findRootToLeafPathWithMaxSumRecursive(currentNode.right, currentSum, currentPath);
		}
		currentPath.remove(currentPath.size() - 1);
		currentSum -= currentNode.val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Integer> result = FindRootToLeafPathMaxSum.findRootToLeafPathWithMaxSum(root);
		System.out.println("Root to leaf path with max : " + result);
	}
}
