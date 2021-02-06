package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbrevation {
	
	public static List<String> generateGeneralizedAbbrevation(String word) {
		List<String> result = new ArrayList<>();
		// TODO: Write your own code
		return result;
	}

	public static void main(String[] args) {
		List<String> result = GeneralizedAbbrevation.generateGeneralizedAbbrevation("BAT");
		System.out.println("Generalized abbrevation are: " + result);
		result = GeneralizedAbbrevation.generateGeneralizedAbbrevation("code");
		System.out.println("Generalized abbrevation are: " + result);
	}

}
