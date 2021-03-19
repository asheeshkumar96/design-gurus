package com.topKElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem 1
 *
 */
public class RearrangeStringKDistinctApart {
	
	public static String reorganizeString(String str, int k) {
		if(k <= 1)
			return str;
		
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for(char chr : str.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());
		
		// add all characters to the max heap
		maxHeap.addAll(charFrequencyMap.entrySet());
		
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuilder resultString = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Entry<Character, Integer> currentEntry = maxHeap.poll();
			resultString.append(currentEntry.getKey());
			currentEntry.setValue(currentEntry.getValue() - 1);
			queue.offer(currentEntry);
			if(queue.size() == k) {
				Entry<Character, Integer> entry = queue.poll();
				if(entry.getValue() > 0)
					maxHeap.add(entry);
			}
		}
		
		// if we were successful in appending all the characters to the result string, return it
		return resultString.length() == str.length() ? resultString.toString() : "";
	}

	public static void main(String[] args) {
		System.out.println("Reorganized string: " + RearrangeStringKDistinctApart.reorganizeString("mmpp", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistinctApart.reorganizeString("Programming", 3));
		System.out.println("Reorganized string: " + RearrangeStringKDistinctApart.reorganizeString("aab", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistinctApart.reorganizeString("aappa", 3));
	}
}
