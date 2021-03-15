package com.misc;

import java.util.PriorityQueue;

public class KthSmallestNumberUsingHeap {
	
	public static int findKthSmallestNumber(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (n1, n2) -> n2 - n1);
		// put first k numbers in the max heap
		for(int i = 0; i < k; i++)
			maxHeap.add(nums[i]);
		
		// go through the remaining numbers of the array, if the number from array is smaller than the 
		// top(biggest) number of the heap, remove the top number from heap and add the number from array
		for(int i = k ; i < nums.length; i++) {
			if(nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		
		// the root of the heap has Kth smallest number
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int result = KthSmallestNumberUsingHeap.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 3);
		System.out.println("Kth smallest number is: " + result);
		
		result = KthSmallestNumberUsingHeap.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 4);
		System.out.println("Kth smallest number is: " + result);
		
		result = KthSmallestNumberUsingHeap.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);
	}

}
