package com.depthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// official
public class CountAllPathSum {
	
	public static int countPaths(TreeNode root, int S) {
		List<Integer> currentPath = new LinkedList<>();
		return countPathRecursive(root, S, currentPath);
	}

	private static int countPathRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
		if(currentNode == null)
			return 0;
		
		// add the currentNode to path
		currentPath.add(currentNode.val);
		int pathCount = 0, pathSum = 0;
		// find the sums of all sub-paths in the current path list
		ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
		while(pathIterator.hasPrevious()) {
			pathSum += pathIterator.previous();
			// if sum of any sum-path is equal to 'S' we increment our path count.
			if(pathSum == S) {
				pathCount++;
			}
		}
		
		// traverse the left sub-tree
		pathCount += countPathRecursive(currentNode.left, S, currentPath);
		// traverse the right sub-tree
		pathCount += countPathRecursive(currentNode.right, S, currentPath);
		
		// remove the current node from the path to backtrack, 
		// we need to remove the current node while we are going up the recursive call stack.
		currentPath.remove(currentPath.size() - 1);
		
		return pathCount;
	}
	
	/*
	  public int pathSum(TreeNode root, int sum) {  
	    if (root == null)
	      return 0;
	    
	    return pathSum(root.left, sum)
	      + pathSum(root.right, sum)
	      + pathSum2(root, sum);
	  }
	  
	  public int pathSum2(TreeNode node, int sum) 
	  { 
	    if (node == null)
	      return 0;
	    
	    var count = 0;
	    if (node.val == sum)
	      count = 1;
	    
	    var newSum = sum - node.val;
	    count += pathSum2(node.left, newSum);
	    count += pathSum2(node.right, newSum);
	    
	    return count;
	  }
	  */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
	}
}
