package com.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
	
	// also official
	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		findPathsRecursive(root, sum, currentPath, allPaths);
		return allPaths;
	}
	
	private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
		if(currentNode == null)
			return;
		
		// add the current node to the path
		currentPath.add(currentNode.val);
		//System.out.println("inserting the node: " + currentNode.val);
		
		// if the current node is leaf and its value is equal to sum, save the current path
		if(currentNode.val == sum && currentNode.left == null &&  currentNode.right == null) {
			System.out.println("Found a path..." + currentPath);
			allPaths.add(new ArrayList<Integer>(currentPath));
		} else {
			// traverse the left sub-tree
			// System.out.println("traversing the left subtree");
			findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
			// traverse the right sub-tree
			// System.out.println("traversing the right subtree");
			findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
		}
			
		// remove the current node from the path to backtrack,
		// we need to remove the current node while we are going up the recursive call stack
		currentPath.remove(currentPath.size() -1);
		// Integer removedNode = currentPath.remove(currentPath.size() -1);
		// System.out.println("removing the node with value: " + removedNode);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);
	}

}
