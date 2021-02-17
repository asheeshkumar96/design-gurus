package com.modifiedBinarySearch;

public class CeilingOfANumberOfficial {
	
	// official solution, but the returning of start is out of understanding ???
	public static int searchCeilingOfANumber(int[] arr, int key) {
		if(key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
			return -1;
		
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(key < arr[mid]) {
				end = mid - 1;
			} else if(key > arr[mid]) {
				start = mid + 1;
			} else { // found the key
				return mid;
			}
		}
		
		// since the loop is running until 'start <= end', so at the end of the while loop, 'start == end + 1'
		// we are not able to find the element in the given array, so next big number will be arr[start]
		return start;
	}
	
	public static void main(String[] args) {
		System.out.println(CeilingOfANumberOfficial.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(CeilingOfANumberOfficial.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(CeilingOfANumberOfficial.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
		System.out.println(CeilingOfANumberOfficial.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	}

}
