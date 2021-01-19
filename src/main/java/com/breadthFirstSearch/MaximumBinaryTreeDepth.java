package com.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Similar Problems #
Problem 1: Given a binary tree, find its maximum depth (or height).
 * @author asheesh
 *
 */
public class MaximumBinaryTreeDepth {
	
	// also the official is same as this one
	public static int findMaxDepth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int maximumTreeDepth = 0;
		while(!queue.isEmpty()) {
			maximumTreeDepth++;
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				// insert the children of current node in the queue
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}
		return maximumTreeDepth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MaximumBinaryTreeDepth.findMaxDepth(root));

		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MaximumBinaryTreeDepth.findMaxDepth(root));
	}

}
