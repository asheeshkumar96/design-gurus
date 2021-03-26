package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
	
	// same as LongestSubstringKDistinct, here the k is fixed to 2
	// also official, 
	// time complexity O(N + N) => O(N), space complexity O(1) as there can be a maximum of three types of fruites stored in the frequency map
	public static int findLength(char[] arr) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
		// we'll try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			char rightChar = arr[windowEnd];
			fruitFrequencyMap.put(rightChar, fruitFrequencyMap.getOrDefault(rightChar, 0) + 1);
			// shrink the sliding window, until we are left with '2' fruites in
			// the frequency map
			while (fruitFrequencyMap.size() > 2) {
				char leftChar = arr[windowStart];
				fruitFrequencyMap.put(leftChar, fruitFrequencyMap.getOrDefault(leftChar, 0) - 1);
				if (fruitFrequencyMap.get(leftChar) == 0) {
					fruitFrequencyMap.remove(leftChar);
				}
				windowStart++; // shrink the window
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}

}
