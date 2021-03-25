package com.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {
	
	// the main for loop managing the sliding window takes O(n) but creating subarrays can take up to O(n^2)
	// in the worse case. Therefore, overall algorithm will take O(n^3).
	// Ignoring the space required for output list, the algorithm runs in O(n) , which is used for the temp list.
	// the space required for output list worst case is O(n^2)
	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int product = 1, left = 0; 
		for(int right = 0; right < arr.length; right++) {
			product *= arr[right];
			while (product >= target && left < arr.length)
				product /= arr[left++];
			
			// since the product of all numbers from left to right is less than the target therefore, 
			// all subarrys from left to right will have a product less than the target too; to avoid
			// duplicates, we will start with a subarray containing only arr[right] and then extend it
			List<Integer> tempList = new ArrayList<>();
			for(int i = right; i >= left; i--) {
				tempList.add(0, arr[i]);
				result.add(new ArrayList<>(tempList));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
	}

}
