package com.subsets;

// official
public class CountUniqueTreesOfficial {
	
	private int countTrees(int n) {
		if(n <= 1)
			return 1;
		int count = 0;
		for(int i = 1; i <= n; i++) {
			int countOfLeftSubtrees = countTrees(i - 1);
			int countOfRightSubtrees = countTrees(n - i);
			count += (countOfLeftSubtrees * countOfRightSubtrees);
		}
		return count;
	}

	public static void main(String[] args) {
		CountUniqueTreesOfficial ct = new CountUniqueTreesOfficial();
		int count = ct.countTrees(3);
		System.out.println("Total trees: " + count);
	}
}
