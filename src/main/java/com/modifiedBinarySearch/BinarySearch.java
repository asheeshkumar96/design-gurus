package com.modifiedBinarySearch;

public class BinarySearch {
	
	public static int search(int[] arr, int key) {
		if(arr.length == 0)
			return -1;
		if(arr.length == 1 && arr[0] == key)
			return 0;
		
		boolean isIncreasingOrder = arr[arr.length - 1] > arr[0];
		return binarySearch(arr, 0, arr.length, key, isIncreasingOrder);
	}
	
	private static int binarySearch(int [] arr, int startIndex, int endIndex, int key, boolean isIncreasingOrder) {
		int midIndex = startIndex + (endIndex - startIndex) / 2;
		if(arr[midIndex] == key) {
			return midIndex;
		} else if(startIndex > endIndex) {
			System.out.println("Search finished..");
			return -1;
		} else {
			int index;
			if(isIncreasingOrder) {
				if(arr[midIndex] > key) {
					index = binarySearch(arr, startIndex, midIndex - 1, key, isIncreasingOrder);
				} else {
					index = binarySearch(arr, midIndex + 1, endIndex, key, isIncreasingOrder);
				}
				
			} else { // for decreasing ordered array
				if(arr[midIndex] > key) {
					index = binarySearch(arr, midIndex + 1, endIndex, key, isIncreasingOrder);
				} else {
					index = binarySearch(arr, startIndex, midIndex - 1, key, isIncreasingOrder);
				}
			}
			return index;
		}
	}

	public static void main(String[] args) {
		System.out.println(BinarySearch.search(new int[] {4, 6, 10}, 10));
		System.out.println(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6, 7}, 5));
		System.out.println(BinarySearch.search(new int[] {10, 6, 4}, 10));
		System.out.println(BinarySearch.search(new int[] {10, 6, 4}, 4));
	}

}
