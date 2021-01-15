package com.cyclicSort;

import java.util.Arrays;

public class FindCorruptNums {

	public static int[] findNumbers(int[] nums) {
		int duplicate = -1;
		int missing = -1;
		int i = 0;
		while (i < nums.length) {
			//System.out.println("index = " + i + " the number should be = " + (i + 1) + " but it is actually = " + nums[i]);
			if (nums[i] != i + 1) {
				if (nums[nums[i] - 1] == nums[i]) {
					duplicate = nums[i];
					//System.out.println("Found the duplicate...");
					i++;
				} else {
					//System.out.println("BeforeSwapping: " + Arrays.toString(nums));
					swap(nums, i, nums[i] - 1);
					//System.out.println("After swapping: " + Arrays.toString(nums));
				}
			} else {
				i++;
			}
		}

		missing = nums.length;
		for (i = 0; i < nums.length; i++) {
			// System.out.println("current value: " + nums[i]);
			if (nums[i] != i + 1) {
				missing = i + 1;
			}
		}
		return new int[] {duplicate, missing};
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 })));
		System.out.println(Arrays.toString(FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 })));
	}
}
