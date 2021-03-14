package com.knapsack;

public class SubsetSumCountBottomup {
	
	public int countSubsets(int[] num, int sum) {
		int n = num.length;
		Integer[][] dp = new Integer[n][sum + 1];
		
		// populate the sum=0 columns, as we will always have an empty set for zero sum
		for(int i = 0; i < n; i++)
			dp[i][0] = 1;
		
		// with only one number, we can form a subset only when the required sum is equal to its value
		for(int s = 1; s <= sum; s++) {
			dp[0][s] = (num[0] == s ? 1 : 0);
		}
		
		// process all subsets for all sums
		for(int i = 1; i < num.length; i++) {
			for(int s = 1; s <= sum; s++) {
				// exclude the number
				dp[i][s] = dp[i - 1][s];
				// include the number if it does not exceed the sum
				if(s >= num[i])
					dp[i][s] += dp[i - 1][s - num[i]];
			}
		}
		
		// the bottom-right corner will have our answer
		return dp[num.length - 1][sum];
	}

	public static void main(String[] args) {
		SubsetSumCountBottomup ssc = new SubsetSumCountBottomup();
		int[] num = {1, 1, 2,  3};
		System.out.println(ssc.countSubsets(num, 4));
		num = new int[]{1, 2, 7, 1, 5};
		System.out.println(ssc.countSubsets(num, 9));
	}
}
