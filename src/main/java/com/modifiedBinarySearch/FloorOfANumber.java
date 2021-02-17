package com.modifiedBinarySearch;

public class FloorOfANumber {
	
	public static int searchFloorOfANumber(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		int res = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(arr[mid] == key) {
				return mid;
			}
			
			if(arr[mid] < key) {
				res = mid;
				start = mid + 1;
			} else if(arr[mid] > key) {
				end = mid - 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
		System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
	}
}
