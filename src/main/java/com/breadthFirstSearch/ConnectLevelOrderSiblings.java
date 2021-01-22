package com.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {
	
	public static void connectOfficial(TreeNodeV1 root) {
		if (root == null) 
			return;
		
		Queue<TreeNodeV1> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNodeV1 previousNode = null;
			int levelSize = queue.size();
			// connect all nodes of this level
			for(int i = 0; i < levelSize; i++) {
				TreeNodeV1 currentNode = queue.poll();
				if (previousNode != null)
					previousNode.next = currentNode;
				previousNode = currentNode;
				
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null) 
					queue.offer(currentNode.right);
			}
		}
	}
	
	
	public static void connect(TreeNodeV1 root) {
		if (root == null)
			return;
		
		Queue<TreeNodeV1> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			TreeNodeV1 currentNode  = null;
			for(int i = 0; i < levelSize; i++) {
				TreeNodeV1 tempNode = queue.poll();
				if(tempNode.left != null) 
					queue.offer(tempNode.left);
				if(tempNode.right != null)
					queue.offer(tempNode.right);
				
				if(currentNode != null) {
					currentNode.next = tempNode;
				}
				currentNode = tempNode;
			}
		}
	}

	public static void main(String[] args) {
		TreeNodeV1 root = new TreeNodeV1(12);
		root.left = new TreeNodeV1(7);
		root.right = new TreeNodeV1(1);
		root.left.left = new TreeNodeV1(9);
		root.right.left = new TreeNodeV1(10);
		root.right.right = new TreeNodeV1(5);
		//ConnectLevelOrderSiblings.connect(root);
		ConnectLevelOrderSiblings.connectOfficial(root);
		System.out.println("Level order traversal using 'next' pointer");
		root.printLevelOrder();
	}
}
