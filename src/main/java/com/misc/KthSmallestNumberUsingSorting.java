package com.misc;

import java.util.Arrays;

public class KthSmallestNumberUsingSorting {
	
	// bruteforce using sorting
	public static int findKthSmallestNumber(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[k - 1];
	}

	public static void main(String[] args) {
		int result = KthSmallestNumberUsingSorting.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 3);
		System.out.println("Kth smallest number is: " + result);
		
		result = KthSmallestNumberUsingSorting.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 4);
		System.out.println("Kth smallest number is: " + result);
		
		result = KthSmallestNumberUsingSorting.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);
	}

}
