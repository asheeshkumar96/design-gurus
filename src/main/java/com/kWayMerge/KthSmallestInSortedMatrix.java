package com.kWayMerge;

import java.util.PriorityQueue;

class MatrixNode {
	int row;
	int col; 
	MatrixNode(int row, int col) { 
		this.row = row;
		this.col = col;
	}
}

public class KthSmallestInSortedMatrix {
	
	// also official
	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<MatrixNode> minHeap = new PriorityQueue<MatrixNode>(
				(n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
		
		for(int i = 0; i < matrix.length; i++)
			minHeap.add(new MatrixNode(i, 0));
		
		int numberCount = 0, result = 0;
		while (!minHeap.isEmpty()) {
			MatrixNode node = minHeap.poll();
			result = matrix[node.row][node.col];
			if(++numberCount == k)
				break;
			node.col++;
			if(matrix[node.row].length > node.col)
				minHeap.add(node);
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
		int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
		System.out.println("Kth smallest number is: " + result);
	}

}
