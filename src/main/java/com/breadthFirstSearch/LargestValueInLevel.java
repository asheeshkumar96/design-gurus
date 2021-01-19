package com.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Similar Problems #
Problem 1: Find the largest value on each level of a binary tree.

Solution: We will follow a similar approach, but instead of having a running sum we will track the maximum value of each level.

maxValue = max(maxValue, currentNode.val)
 * @author asheesh
 *
 */
public class LargestValueInLevel {
	
	public static List<Integer> maximumInLevels(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) 
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			int levelMax = Integer.MIN_VALUE;
			for(int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				levelMax = Math.max(levelMax, currentNode.val);
				if(currentNode.left != null) 
					queue.offer(currentNode.left);
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(levelMax);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Integer> result = LargestValueInLevel.maximumInLevels(root);
		System.out.println("Level averages are: " + result);
	}

}
