package com.knapsack;

public class SubsetSumCountTopdown {
	
	public int countSubsets(int[] num, int sum) {
		Integer[][] dp = new Integer[num.length][sum + 1];
		return this.countSubsetRecursive(dp, num, sum, 0);
	}
	
	private int countSubsetRecursive(Integer[][] dp, int[] num, int sum, int currentIndex) {
		// base checks 
		if(sum == 0)
			return 1;
		
		if(num.length == 0 || currentIndex >= num.length)
			return 0;
		
		// check if we have not already processed a similar problem
		if(dp[currentIndex][sum] == null) {
			// recursive call after selecting the number at the currentIndex
			// if the number at currentIndex exceeds the sum, we shouldn't process this
			int sum1 = 0;
			if(num[currentIndex] <= sum)
				sum1 = countSubsetRecursive(dp, num, sum - num[currentIndex], currentIndex+1);
			
			// recursive call after excluding the number at the currentIndex
			int sum2 = countSubsetRecursive(dp, num, sum, currentIndex + 1);
			
			dp[currentIndex][sum] = sum1 + sum2;
		}
			
		return dp[currentIndex][sum];
	}

	public static void main(String[] args) {
		SubsetSumCountTopdown ssc = new SubsetSumCountTopdown();
		int[] num = {1, 1, 2,  3};
		System.out.println(ssc.countSubsets(num, 4));
		num = new int[]{1, 2, 7, 1, 5};
		System.out.println(ssc.countSubsets(num, 9));
	}
}
