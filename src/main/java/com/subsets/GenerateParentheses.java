package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<>();
		generateValidParenthesesRecursively(num, num, "", result);
		return result;
	}
	
	private static void generateValidParenthesesRecursively(int openCounter, int closeCounter, String value, List<String> result) {
		if(openCounter == 0 && closeCounter == 0) {
			result.add(value);
			return;
		}
		
		// as long as open counters are there, we have a choice to put opening bracket
		if(openCounter != 0) {
			String value1 = value;
			value1 = value1 + "(";
			generateValidParenthesesRecursively(openCounter - 1, closeCounter, value1, result);
		}
		
		// we can close only and only if the opening is already used
		if(closeCounter > openCounter) {
			String value2 = value;
			value2 = value2 + ")";
			generateValidParenthesesRecursively(openCounter, closeCounter - 1, value2, result);
		}
	}

	public static void main(String[] args) { 
		List<String> result = GenerateParentheses.generateValidParentheses(2); 
		System.out.println("All combinations of balanced parentheses are: " + result);
		result = GenerateParentheses.generateValidParentheses(3); 
		System.out.println("All combinations of balanced parentheses are: " + result);
	}
}
