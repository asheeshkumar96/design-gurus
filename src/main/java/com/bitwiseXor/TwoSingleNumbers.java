package com.bitwiseXor;

public class TwoSingleNumbers {
	
	public static int[] findSingleNumbers(int[] nums) {
		int XorOfTwoMissingNumbers = 0;
		for(int i = 0; i < nums.length; i++) {
			XorOfTwoMissingNumbers ^= nums[i];
		}
		
		// get the rightmost bit that is '1'
		int rightmostSetBit = 1;
		while( (rightmostSetBit & XorOfTwoMissingNumbers) == 0) {
			rightmostSetBit = rightmostSetBit << 1;
		}
		
		int num1 = 0, num2 = 0;
		for(int num: nums) {
			if( (num & rightmostSetBit) != 0) // the bit is set
				num1 ^= num;
			else // the bit is not set
				num2 ^= num;
		}
		return new int[] {num1, num2};
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
		int[] result = TwoSingleNumbers.findSingleNumbers(arr);
		System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
		
		arr = new int[] {2, 1, 3, 2};
		result = TwoSingleNumbers.findSingleNumbers(arr);
		System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
	}
}
