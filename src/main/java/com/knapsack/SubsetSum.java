package com.knapsack;

public class SubsetSum {
	
	public boolean canPartition(int[] nums, int sum) {
		int n = nums.length;
		boolean[][] dp = new boolean[n][sum + 1];
		
		// populate the sum=0 columns, as we can always form '0' sum with an empty set
		for(int i = 0; i < n; i++)
			dp[i][0] = true;
		
		// with only one number, we can form a subset only when the required sum is
		// equal to its value
		for(int s = 1; s <= sum; s++) {
			dp[0][s] = (nums[0] == s ? true: false);
		}
		
		// process all subsets for all sums
		for(int i = 1; i < n; i++) {
			for(int s = 1; s <= sum ; s++) {
				// if we can get the sum 's' without the number at index 'i'
				if(dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if(s >= nums[i]) {
					// else include the number and see if we can find a subset to get the remaining
					dp[i][s] = dp[i - 1][s - nums[i]];
				}
			}
		}
		
		// the bottom-right corner will have our answer
		return dp[n - 1][sum];
	}

	public static void main(String[] args) {
		SubsetSum ss = new SubsetSum();
		int[] nums = {1, 2, 3, 7};
		System.out.println(ss.canPartition(nums, 6));
		nums =  new int[] {1, 2, 7, 1, 5};
		System.out.println(ss.canPartition(nums, 10));
		nums =  new int[] {1, 3, 4, 8};
		System.out.println(ss.canPartition(nums, 6));
	}

}
