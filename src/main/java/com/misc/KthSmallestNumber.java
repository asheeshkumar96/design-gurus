package com.misc;

public class KthSmallestNumber {
	
	public static int findKthSmallestNumber(int[] nums, int k) {
		// TODO: Write your own code
		return -1;
	}

	public static void main(String[] args) {
		int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 3);
		System.out.println("Kth smallest number is: " + result);
		
		result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5}, 4);
		System.out.println("Kth smallest number is: " + result);
		
		result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);
	}

}
