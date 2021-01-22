package com.breadthFirstSearch;

public class TreeNodeV1 {

	int val;
	TreeNodeV1 left;
	TreeNodeV1 right;
	TreeNodeV1 next;
	
	public TreeNodeV1(int x) {
		this.val = x;
		left = right = next = null;
	}
	
	// level order traversal using 'next' pointer
	void printLevelOrder() {
		TreeNodeV1 nextLevelRoot = this;
		while (nextLevelRoot != null) {
			TreeNodeV1 current  = nextLevelRoot;
			nextLevelRoot = null;
			while (current != null) {
				System.out.print(current.val + " ");
				if(nextLevelRoot == null) {
					if(current.left != null)
						nextLevelRoot = current.left;
					else if(current.right != null)
						nextLevelRoot = current.right;
				}
				current = current.next;
			}
			System.out.println();
		}
	}
	
}
