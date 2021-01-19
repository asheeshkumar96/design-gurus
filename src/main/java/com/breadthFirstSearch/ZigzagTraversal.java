package com.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
	
	// official  solution, elegent use of boolean
	public static List<List<Integer>> traverseOfficial(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean leftToRight = true;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new LinkedList<>();
			for(int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				// add the current node to the current level based on the traverse direction
				if(leftToRight) {
					currentLevel.add(currentNode.val);
				} else {
					currentLevel.add(0, currentNode.val);
				}
				
				// insert the children of current node to the queue
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(currentLevel);
			// reverse the traversal direction
			leftToRight = !leftToRight;
		}
		
		return result;
	}
	
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int counter = 1;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new LinkedList<>();
			for(int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				// add the current node to the current level
				if(counter % 2 == 0) {
					currentLevel.add(0, currentNode.val);
				} else {
					currentLevel.add(currentNode.val);
				}
				
				// insert the children of current node to the queue
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(currentLevel);
			counter++;
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9); 
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5); 
		root.right.left.left = new TreeNode(20); 
		root.right.left.right = new TreeNode(17); 
		List<List<Integer>> result = ZigzagTraversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);

	}
}
