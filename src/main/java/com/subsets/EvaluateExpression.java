package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {
	
	public static List<Integer> diffWaysToEvaluateExpression(String input) {
		List<Integer> result = new ArrayList<>();
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
		System.out.print("Expression evaluations ");
		for(Integer eval: result)
			System.out.print(eval + " ");
		System.out.println();
		
		result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
		System.out.print("Expression evaluations ");
		for(Integer eval: result)
			System.out.print(eval + " ");
		System.out.println();
	}
}
