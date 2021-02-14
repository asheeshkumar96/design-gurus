package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutations {
	
	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		// TODO: Write your own code
		permutations.add(str);
		letterCasePermutations(str, permutations, 0);
		return permutations;
	}
	
	private static void letterCasePermutations(String str, List<String> permutations, int letterIndex) {
		// base case
		if(letterIndex == str.length()) return;
		
		char charAtLetterIndex = str.charAt(letterIndex);
		if(Character.isLowerCase(charAtLetterIndex)) {
			int length = permutations.size();
			for(int i = 0; i < length ; i++) {
				StringBuilder perm = new StringBuilder(permutations.get(i));
				perm.setCharAt(letterIndex, Character.toUpperCase(charAtLetterIndex));
				permutations.add(perm.toString());
			}
			
		} else if(Character.isUpperCase(charAtLetterIndex)) {
			int length = permutations.size();
			for(int i = 0; i < length ; i++) {
				StringBuilder perm = new StringBuilder(permutations.get(i));
				perm.setCharAt(letterIndex, Character.toLowerCase(charAtLetterIndex));
				permutations.add(perm.toString());
			}
		}
		
		letterCasePermutations(str, permutations, letterIndex+1);
		
	}

	public static void main(String[] args) {
		List<String> result = LetterCaseStringPermutations.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);
		result = LetterCaseStringPermutations.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}

}
