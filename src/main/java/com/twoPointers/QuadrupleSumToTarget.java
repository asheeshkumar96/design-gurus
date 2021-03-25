package com.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
	
	// overall complexity will be O(N * Nlog + N^3)
	public static List<List<Integer>> searchQuadruples(int[] arr, int target) {
		Arrays.sort(arr);
		List<List<Integer>> quadruples = new ArrayList<>();
		for(int i = 0; i < arr.length - 3; i++) {
			if(i > 0 && arr[i] == arr[i - 1]) // skip same elements to avoid
				continue;
				
			for(int j = i + 1; j < arr.length - 2; j++) {
				if(j > i + 1 && arr[j] == arr[j - 1])
					continue;
				searchPairs(arr, target, i, j, quadruples);
			}
		}
		return quadruples;
	}
	
	private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
		int left = second + 1;
		int right = arr.length - 1;
		while (left < right) { 
			int sum = arr[first] + arr[second] + arr[left] + arr[right];
			// the comparison can be made with arr[left] + arr[right] == targetSum - arr[first] - arr[second] to avoid overflow
			if(sum == targetSum) { // found the 
				quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
				left++;
				right--;
				while(left < right && arr[left] == arr[left -1])
					left++; // skip same elements to avoid duplicate quadruplets
				while(left < right && arr[right] == arr[right + 1])
					right--; // skip same elements to avoid duplicates
			} else if(sum < targetSum) {
				left++; // we need a pair with a bigger sum
			} else {
				right--; // we need a pair with a smaller sum
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(QuadrupleSumToTarget.searchQuadruples(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println(QuadrupleSumToTarget.searchQuadruples(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
	}
}
