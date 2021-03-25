package slidingWindow;

public class MaxSumSubArrayOfSizeK {
	
	// official, time complexity O(N), space complexity O(1)
	public static int findMaxSumSubArray(int k, int[] arr) {
		int maxSum = 0, windowSum;
		for(int i = 0; i <= arr.length - k; i++) {
			windowSum = 0;
			for(int j = i ; j < i + k ; j++) {
				windowSum += arr[j];
			}
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}
	
	public static int findMaxSumSubArrayBetter(int k, int[] arr) {
		int maxSum = 0, windowSum = 0;
		int windowStart = 0;
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd]; // add the next element
			// slide the window, we don't need to slide if we have not hit the requried window size of k
			if(windowEnd >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart]; // subtract the element going out
				windowStart++; // slide the window ahead
			}
			
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println("Maximum sum of a subarry of size K:" + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		System.out.println("Maximum sum of a subarry of size K:" + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
		
		System.out.println("Maximum sum of a subarry of size K:" + MaxSumSubArrayOfSizeK.findMaxSumSubArrayBetter(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		System.out.println("Maximum sum of a subarry of size K:" + MaxSumSubArrayOfSizeK.findMaxSumSubArrayBetter(2, new int[] { 2, 3, 4, 1, 5 }));
	
	}
}
