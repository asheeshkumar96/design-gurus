package com.bitwiseXor;

public class TwoSingleNumbersOfficial {
	
	// official
	public static int[] findSingleNumbers(int[] nums) {
		// get the XOR of all the numbers
		int n1xn2 = 0;
		for(int num : nums) {
			n1xn2 ^= num;
		}
		
		// get the rightmost bit that is '1'
		int rightmostSetBit = 1;
		while ( (rightmostSetBit & n1xn2) == 0) {
			rightmostSetBit = rightmostSetBit << 1;
		}
		
		int num1 = 0, num2 = 0;
		for(int num : nums) {
			if((num & rightmostSetBit) != 0) // the bit is set
				num1 ^= num;
			else
				num2 ^= num;
		}
		
		return new int[] {num1, num2};
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
		int[] result = TwoSingleNumbersOfficial.findSingleNumbers(arr);
		System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
		
		arr = new int[] {2, 1, 3, 2};
		result = TwoSingleNumbersOfficial.findSingleNumbers(arr);
		System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
	}

}
