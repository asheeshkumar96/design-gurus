package com.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicatesBacktracing {
	
	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		dfs(result, new ArrayList<Integer>(), nums, 0);
		return result;
	}
	
	public static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos) {
		res.add(new ArrayList<>(temp));
		for (int i = pos; i < nums.length; i++) {
			if (i > pos && nums[i] == nums[i - 1])
				continue;
			temp.add(nums[i]);
			dfs(res, temp, nums, i + 1);
			temp.remove(temp.size() - 1); // backtracking 
		}
	}
	

	public static void main(String[] args) {
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] {1, 3, 3});
		System.out.println("Here is the list of subsets: " + result);
		
		result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3});
		System.out.println("Here is the list of subsets: " + result);
	}

}
