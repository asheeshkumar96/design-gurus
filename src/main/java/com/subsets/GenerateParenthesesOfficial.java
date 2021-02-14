package com.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {
	String str;
	int openCount; // open parentheses count
	int closeCount; // close parentheses count
	
	public ParenthesesString(String s, int openCount, int closeCount) {
		this.str = s;
		this.openCount = openCount;
		this.closeCount = closeCount;
	}
}

// official
public class GenerateParenthesesOfficial {
	
	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<>();
		Queue<ParenthesesString> queue = new LinkedList<>();
		queue.add(new ParenthesesString("", 0, 0));
		while(!queue.isEmpty()) {
			ParenthesesString ps = queue.poll();
			// if we've reached the maximum number of open and close parentheses, add to result
			if(ps.openCount == num && ps.closeCount == num) {
				result.add(ps.str);
			} else {
				if(ps.openCount < num) // if we can add an open parentheses, add it
					queue.add(new ParenthesesString(ps.str+"(", ps.openCount + 1, ps.closeCount));
				
				if(ps.openCount > ps.closeCount) // if we can add a close parentheses, add
					queue.add(new ParenthesesString(ps.str+")", ps.openCount, ps.closeCount + 1));
			}		
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> result = GenerateParenthesesOfficial.generateValidParentheses(2); 
		System.out.println("All combinations of balanced parentheses are: " + result);
		result = GenerateParenthesesOfficial.generateValidParentheses(3); 
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

}
