package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		// TODO: Write your own code
		return subsets;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5});
		System.out.println("Here are all the permutations: " + result);
	}

}
