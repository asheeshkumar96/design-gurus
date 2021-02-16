package com.subsets;

import java.util.HashMap;
import java.util.Map;

// official
public class CountUniqueTreesMemoized {
	
	Map<Integer, Integer> map = new HashMap<>();
	
	public int countTrees(int n) {
		if(map.containsKey(n))
			return map.get(n);
		
		if(n <= 1)
			return 1;
		
		int count = 0;
		for(int i = 1; i <= n; i++) {
			// making 'i' root of the tree
			int countOfLeftSubtrees = countTrees(i - 1);
			int countOfRightSubtrees = countTrees(n - i);
			count += (countOfLeftSubtrees * countOfRightSubtrees);
		}
		map.put(n, count);
		return count;
	}

	public static void main(String[] args) {
		CountUniqueTreesMemoized ct = new CountUniqueTreesMemoized();
		int count = ct.countTrees(3);
		System.out.println("Total trees: " + count);
	}
}
