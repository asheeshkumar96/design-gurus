package com.twoPointers;

public class RemoveDuplicateSimilar {
	
	public static int remove(int[] arr, int key) {
		int nextElement = 0; // index of the next element which is not key
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != key) {
				arr[nextElement] = arr[i];
				nextElement++;
			}
		}
		return nextElement;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
		System.out.println(RemoveDuplicateSimilar.remove(arr, 3));
		
		arr = new int[] { 2, 2, 2, 11 };
		System.out.println(RemoveDuplicateSimilar.remove(arr, 2));
	}
}
