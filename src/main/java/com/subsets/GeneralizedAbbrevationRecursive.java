package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbrevationRecursive {
	
	// official recursive solution
	private static List<String> generateGeneralizedAbbrevation(String word) {
		List<String> result = new ArrayList<>();
		generateAbbrevationRecursive(word, new StringBuilder(), 0, 0, result);
		return result;
	}

	private static void generateAbbrevationRecursive(String word, StringBuilder abWord, int start, int count,
			List<String> result) {
		if(start == word.length()) {
			if(count != 0)
				abWord.append(count);
			result.add(abWord.toString());
		} else {
			// continue abbrevating by incrementing the current abbrevation count
			generateAbbrevationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);
			
			// restart abbrevating, append the count and the current character to the string
			if(count != 0)
				abWord.append(count);
			generateAbbrevationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
		}
	}

	public static void main(String[] args) {
		List<String> result = GeneralizedAbbrevationRecursive.generateGeneralizedAbbrevation("BAT");
		System.out.println("Generalized abbrevation are: " + result);
		result = GeneralizedAbbrevationRecursive.generateGeneralizedAbbrevation("code");
		System.out.println("Generalized abbrevation are: " + result);
	}
}
