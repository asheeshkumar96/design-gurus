package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutations {
	
	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		// TODO: Write your own code
		return permutations;
	}

	public static void main(String[] args) {
		List<String> result = LetterCaseStringPermutations.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);
		result = LetterCaseStringPermutations.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}

}
