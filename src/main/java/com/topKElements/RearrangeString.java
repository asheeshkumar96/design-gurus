package com.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeString {
	
	// official
	public static String rearrangeString(String str) {
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for(char chr : str.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		// add all characters to the max heap
		maxHeap.addAll(charFrequencyMap.entrySet());
		
		Map.Entry<Character, Integer> previousEntry = null;
		StringBuilder resultString = new StringBuilder();
		while(!maxHeap.isEmpty()) { // very tricky
			Entry<Character, Integer> currentEntry = maxHeap.poll();
			// add the previous entry back in the heap if its frequency is greater than zero
			if(previousEntry != null && previousEntry.getValue() > 0)
				maxHeap.offer(previousEntry);
			// append the current character to the result string and decrement its count
			resultString.append(currentEntry.getKey());
			currentEntry.setValue(currentEntry.getValue() - 1);
			previousEntry = currentEntry;
		}
		
		return resultString.length() == str.length() ? resultString.toString() : "";
	}
	
	/**
	 Returns whether the string can be arranged in such a way that no two adjacent characters are some
	 * @param str the string to check for possible arrangement
	 * @return true iff the string can be arranged such that no two adjacent chars are same, false otherwise
	 */
	public static boolean canBeArranged(String str) {
		int n = str.length(); 
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		int max = 0;
		for(char chr: str.toCharArray()) {
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
			if(charFrequencyMap.get(chr) > max)
				max = charFrequencyMap.get(chr);
		}
		
		if(max <= n - max + 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
		
		/*
		System.out.println("Rearranged string: " + RearrangeString.canBeArranged("aappp"));
		System.out.println("Rearranged string: " + RearrangeString.canBeArranged("Programming"));
		System.out.println("Rearranged string: " + RearrangeString.canBeArranged("aapa"));
		*/
	}

}
