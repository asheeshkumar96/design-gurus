package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class PermutationsRecursive {
	
	public static List<List<Integer>> generatePermutations(int[] nums) {
		List<List<Integer>> result  = new ArrayList<>();
		generatePermutationRecursive(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}
	
	private static void generatePermutationRecursive(int[] nums, int index, List<Integer> currentPermutation, List<List<Integer>> result) {
		if(index == nums.length) {
			result.add(currentPermutation);
		} else {
			// create a new permutation by adding the current number at every position
			for(int i = 0; i <= currentPermutation.size(); i++) {
				List<Integer> newPermutation = new ArrayList<>(currentPermutation);
				newPermutation.add(i, nums[index]);
				generatePermutationRecursive(nums, index + 1, newPermutation, result);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = PermutationsRecursive.generatePermutations(new int[] { 1, 3, 5});
		System.out.println("Here are all the permutations: " + result);
	}
}
