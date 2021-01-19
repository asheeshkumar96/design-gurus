package com.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {
	
	// offical solution
	public static int findDepthOffical(TreeNode root) {
		if(root == null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int minimumDepth = 0;
		while(!queue.isEmpty()) {
			minimumDepth++;
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				
				// check if this is a leaf node
				if(currentNode.left == null && currentNode.right == null)
					return minimumDepth;
				
				// insert the children of current node in the queue
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null) 
					queue.offer(currentNode.right);
			}
		}
		return minimumDepth;
	}

	public static int findDepth(TreeNode root) {
		int minDepth = 0;
		if(root == null)
			return minDepth;
		else 
			minDepth++;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isLeafNode = false;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				if(currentNode.left == null) {
					isLeafNode = true;
					break;
				} else {
					queue.offer(currentNode.left);
				}
				
				if(currentNode.right == null) {
					isLeafNode = true;
					break;
				} else {
					queue.offer(currentNode.right);
				}
			}
			if(isLeafNode) {
				break;
			}
			minDepth++;
		}
		
		return minDepth;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepthOffical(root));

		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepthOffical(root));

	}
}
