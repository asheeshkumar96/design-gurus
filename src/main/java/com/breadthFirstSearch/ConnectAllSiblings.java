package com.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
	
	// official, elegent solution
	public static void connectOfficial(TreeNodeV2 root) {
		if(root == null)
			return;
		
		Queue<TreeNodeV2> queue = new LinkedList<>();
		queue.offer(root);
		TreeNodeV2 currentNode = null, previousNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			if(previousNode != null)
				previousNode.next = currentNode;
			previousNode = currentNode;
			
			// insert the children of current node in the queue
			if(currentNode.left != null)
				queue.offer(currentNode.left);
			if(currentNode.right != null) 
				queue.offer(currentNode.right);
		}
	}
 	
	public static void connect(TreeNodeV2 root) {
		if (root == null) 
			return;
		
		Queue<TreeNodeV2> queue = new LinkedList<>();
		queue.offer(root);
		TreeNodeV2 previousLevelLastNode = null;
		while (!queue.isEmpty()) {
			TreeNodeV2 previousNode = null;
			int levelSize = queue.size();
			// connect all nodes of this level
			for(int i = 0; i < levelSize; i++) {
				TreeNodeV2 currentNode = queue.poll();
				
				if(i == 0 && previousLevelLastNode != null)
					previousLevelLastNode.next = currentNode;
				
				if (previousNode != null)
					previousNode.next = currentNode;
				previousNode = currentNode;
				
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if(currentNode.right != null) 
					queue.offer(currentNode.right);
			}
			previousLevelLastNode = previousNode;
		}
	}

	public static void main(String[] args) {
		TreeNodeV2 root = new TreeNodeV2(12);
		root.left = new TreeNodeV2(7);
		root.right = new TreeNodeV2(1);
		root.left.left = new TreeNodeV2(9);
		root.right.left = new TreeNodeV2(10);
		root.right.right = new TreeNodeV2(5);
		// ConnectAllSiblings.connect(root);
		ConnectAllSiblings.connectOfficial(root);
		root.printTree();
	}

}
