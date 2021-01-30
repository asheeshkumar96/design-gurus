package com.depthFirstSearch;

import java.util.HashMap;
import java.util.Map;

// Optimized with O(n) time complexity
public class CountAllPathSumOptimized {
	
	public static int countPaths(TreeNode root, int S) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return countPathsRecursive(root, 0, S, map);
	}
	
	public static int countPathsRecursive(TreeNode currentNode, int runningSum, int targetSum,
			Map<Integer, Integer> map) {
		if (currentNode == null)
			return 0;

		runningSum += currentNode.val;

		int count = map.getOrDefault(runningSum - targetSum, 0);
		map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);

		count += countPathsRecursive(currentNode.left, runningSum, targetSum, map)
				+ countPathsRecursive(currentNode.right, runningSum, targetSum, map);
		map.put(runningSum, map.get(runningSum) - 1);
		return count;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + CountAllPathSumOptimized.countPaths(root, 11));
	}

}
