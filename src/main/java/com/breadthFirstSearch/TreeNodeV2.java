package com.breadthFirstSearch;

public class TreeNodeV2 {

	int val;
	TreeNodeV2 left;
	TreeNodeV2 right;
	TreeNodeV2 next;
	
	TreeNodeV2(int x) {
		val = x;
		left = right = next = null;
	}
	
	// tree traversal using 'next' pointer
	public void printTree() {
		TreeNodeV2 current = this;
		System.out.print("Traversal using 'next' pointer: ");
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}
}
