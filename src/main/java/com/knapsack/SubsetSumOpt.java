package com.knapsack;

public class SubsetSumOpt {
	
	public boolean canPartition(int[] nums, int sum) {
		int n = nums.length;
		boolean[] dp = new boolean[sum + 1];
		
		// handle sum=0, as we can always have 0 sum with an empty set
		dp[0] = true;
		
		// with only one number, we can have a subset only when the required sum is equal to its value
		for(int s = 1; s <= sum; s++) {
			dp[s] = (nums[0] == s ? true: false);
		}
		
		// process all subsets for all sums
		for(int i = 1; i < n; i++) {
			for(int s = sum; s >= 0 ; s--) {
				// dp[s] == true, this means we can get the sum 's' without num[i], hence we can move on
				// to next number else we can include num[i] and see if we can find a subset to get the 
				// remaining sum
				if(!dp[s] && s >= nums[i]) {
					dp[s] = dp[s - nums[i]];
				}
			}
		}
		
		// the bottom-right corner will have our answer
		return dp[sum];
	}

	public static void main(String[] args) {
		SubsetSumOpt ss = new SubsetSumOpt();
		int[] nums = {1, 2, 3, 7};
		System.out.println(ss.canPartition(nums, 6));
		nums =  new int[] {1, 2, 7, 1, 5};
		System.out.println(ss.canPartition(nums, 10));
		nums =  new int[] {1, 3, 4, 8};
		System.out.println(ss.canPartition(nums, 6));
	}

}
