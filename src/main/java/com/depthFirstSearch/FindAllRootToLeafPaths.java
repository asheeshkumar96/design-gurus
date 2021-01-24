package com.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Given a binary tree, return all root-to-leaf paths.

Solution: We can follow a similar approach. We just need to remove the “check for the path sum”.
 *
 */
public class FindAllRootToLeafPaths {
	
	public static List<List<Integer>> findRootToLeafPaths(TreeNode root) {
		List<List<Integer>> allRootToLeafPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		findRootToLeafPathsRecursive(root, currentPath, allRootToLeafPaths);
		return allRootToLeafPaths;
	}
	
	private static void findRootToLeafPathsRecursive(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allRootToLeafPaths) {
		if(currentNode == null)
			return;
		
		currentPath.add(currentNode.val);
		
		if(currentNode.left == null && currentNode.right == null) {
			allRootToLeafPaths.add(new ArrayList<Integer>(currentPath));
		} else {
			findRootToLeafPathsRecursive(currentNode.left, currentPath, allRootToLeafPaths);
			
			findRootToLeafPathsRecursive(currentNode.right, currentPath, allRootToLeafPaths);
		}
		
		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = FindAllRootToLeafPaths.findRootToLeafPaths(root);
		System.out.println("Tree paths with with leaf nodes : " + result);
	}
}
