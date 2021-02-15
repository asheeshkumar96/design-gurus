package com.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class AbbreviateWord {
	StringBuilder str;
	int start; 
	int count;
	
	public AbbreviateWord(StringBuilder str, int start, int count) {
		this.str = str;
		this.start = start;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "AbbreviateWord [str=" + str + ", start=" + start + ", count=" + count + "]";
	}
}

// official solution
public class GeneralizedAbbrevation {
	
	public static List<String> generateGeneralizedAbbrevation(String word) {
		int wordLen = word.length();
		List<String> result = new ArrayList<>();
		Queue<AbbreviateWord> queue = new LinkedList<>();
		queue.add(new AbbreviateWord(new StringBuilder(), 0, 0));
		while (!queue.isEmpty()) {
			AbbreviateWord abWord = queue.poll();
			System.out.println("abWord = " + abWord);
			if(abWord.start == wordLen) {
				System.out.println("Inside if");
				if(abWord.count != 0)
					abWord.str.append(abWord.count);
				result.add(abWord.str.toString());
			} else {
				// continue abbrevating by incrementing the current abbrevation count
				System.out.println("Inside else");
				queue.add(new AbbreviateWord(new StringBuilder(abWord.str), abWord.start+1, abWord.count + 1));
				
				// restart abbrevating, append the count and the current character to the string
				if(abWord.count != 0)
					abWord.str.append(abWord.count);
				queue.add(new AbbreviateWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)), abWord.start + 1, 0));
			}
		}
		return result;
	}
 
	public static void main(String[] args) {
		List<String> result = GeneralizedAbbrevation.generateGeneralizedAbbrevation("BAT");
		System.out.println("Generalized abbrevation are: " + result);
		result = GeneralizedAbbrevation.generateGeneralizedAbbrevation("code");
		System.out.println("Generalized abbrevation are: " + result);
	}

}
