package com.modifiedBinarySearch;

// not working solution 
public class SearchBitonicArray {
	
	// not the right approach, hence nog good,
	// The right approach is to  partition the array in two array applying BS independentally for increasing and decreasing
	// But for that we need to find the partition index, since it is bitonic array, i.e., we need to find index of the maximum element
	// after finding maximum element we can independentally partion array from 0 to index and index + 1 to length - 1. 
	public static int search(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(arr[mid] > arr[mid + 1] ) { // decreasing section
				if(arr[mid] > key) {
					start = mid + 1;
				} else if(arr[mid] < key) {
					end = mid - 1;
				} else {
					return mid;
				}
			} else  { // increasing section
				if(arr[mid] > key) {
					end = mid - 1;
				} else if(arr[mid] < key){
					start = mid + 1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
		System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
		System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
		System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
	}

}
