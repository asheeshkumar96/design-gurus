package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
	
	public static int findLength(String str) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> charIndexMap = new HashMap<>(); // this can also be replaced with a fixed size char array with 26 length
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			// if the map already contains the 'rightChar', shrink the window from the beginning so that 
			// we have only one occurance of 'rightChar'
			if(charIndexMap.containsKey(rightChar)) {
				// this is tricky; in the current window, we will not have any 'rightChar' after its previous index
				// and if windowStart is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
				windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
			}
			charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
	}
}
