package com.twoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
	
	// the logic in the or part of updation of smallestDifference, unalbe to comprehend
	public static int searchTriplet(int[] arr, int targetSum) {
		if (arr == null || arr.length < 2)
			throw new IllegalArgumentException();
		
		Arrays.sort(arr);
		int smallestDifference = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1, right = arr.length - 1;
			// why not less than or equal to /?????????, why less than only
			while (left < right) {
				// comparing the sum of three numbers to the 'targetSum' can cause overflow
				// so, we will try to find a target difference
				int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
				if (targetDiff == 0) // we've found a triplet with an exact sum
					return targetSum - targetDiff; // return sum of all the numbers

				if (Math.abs(targetDiff) < Math.abs(smallestDifference)
						|| (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference)) { // ??????????????
					smallestDifference = targetDiff; // save the closest and the biggest difference
				}

				if (targetDiff > 0)
					left++; // we need a triplet with a bigger sum
				else
					right--; // we need a triplet with a smaller sum
			}
		}
		return targetSum - smallestDifference;
	}

	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}
}
