package com.topKElements;

import java.util.PriorityQueue;

public class SumOfElements {
	
	public static int findSumOfElements(int[] nums, int k1, int k2) {
		int first = findKthSmallestNumber(nums, k1);
		int second = findKthSmallestNumber(nums, k2);
		int sum = 0;
		for(int n : nums) {
			if(n > first && n < second) {
				sum += n;
			}
		}
		return sum;
	}
	
	public static int findKthSmallestNumber(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
		// put first k numbers in the max heap
		for(int i = 0; i < k; i++)
			maxHeap.add(nums[i]);
		
		// go through the remaining numbers of the array, if the number from the array is smaller than the 
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
		int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
		System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
		
		result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
		System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
	}
}
