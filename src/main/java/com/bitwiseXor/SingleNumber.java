package com.bitwiseXor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// finding single number from a list where other numbers appear twice
public class SingleNumber {
	
	public static int findSingleNumber(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num: arr) {
			if(map.containsKey(num)) {
				map.remove(num);
			} else {
				map.put(num, 1);
			}
		}
		
		 Iterator<Integer> keyIterator = map.keySet().iterator();
		 if(keyIterator.hasNext())
			 return keyIterator.next();
		 else
			 return 0;
	}

	public static void main(String[] args) {
		System.out.println(findSingleNumber(new int[] {1, 4, 2, 1, 3, 2, 3}));
	}

}
