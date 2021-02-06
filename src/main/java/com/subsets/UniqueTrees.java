package com.subsets;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		this.val = x;
	}
}; 

public class UniqueTrees {
	
	public static List<TreeNode> findUniqueTrees(int n) {
		List<TreeNode> result = new ArrayList<>();
		// TODO: Write your own code
		return result;
	}

	public static void main(String[] args) {
		List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
		System.out.println("Total trees: " + result.size());
	}

}
