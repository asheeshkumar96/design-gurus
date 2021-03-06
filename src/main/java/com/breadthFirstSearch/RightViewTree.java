package com.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {
	
	// official
	public static List<TreeNode> traverseOfficial(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				// if it is the last node of this level, add it to the result
				if(i == levelSize - 1)
					result.add(current);
				// insert the children of current node in the queue
				if (current.left != null)
					queue.offer(current.left);
				if(current.right != null)
					queue.offer(current.right);
			}
		}
		return result;
	}
	
	public static List<TreeNode> traverse(TreeNode root) {
		if (root == null)
			return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<TreeNode> result = new ArrayList<>();
		TreeNode currentNode = null;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				currentNode = queue.poll();
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(currentNode);
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
		root.left.left.left = new TreeNode(3);
		// List<TreeNode> result = RightViewTree.traverse(root);
		List<TreeNode> result = RightViewTree.traverseOfficial(root);
		for(TreeNode node : result) {
			System.out.print(node.val + " ");
		}
		System.out.println();
		
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		// result = RightViewTree.traverse(root);
		result = RightViewTree.traverseOfficial(root);
		for(TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}

}
