package com.bitwiseXor;

public class MissingNumberBrute {
	
	public static int findMissingNumber(int[] arr) {
		int n = arr.length + 1;
		// find some of all numbers from 1 to n
		int s1 = 0;
		for(int i = 1; i <= n; i++)
			s1 += i;
		
		// subtract all numbers in input from sum
		for(int num : arr)
			s1 -= num;
		
		// s1, now , is the missing number
		return s1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 5, 2, 6, 4};
		System.out.println("Missing number is: " + MissingNumberBrute.findMissingNumber(arr));
	}

}
