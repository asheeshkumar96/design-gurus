package com.cyclicSort;

import java.util.Arrays;

public class FindCorruptNums {

  public static int[] findNumbers(int[] nums) {
    int duplicate = -1;
    int missing = -1;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == nums[nums[i]-1]) {
          duplicate = nums[i];
          missing = i + 1;
          break;
        } else {
          if(nums[i] != i + 1)  {
            swap(nums, i, nums[i]-1);
          }
        }
    }
    return new int[]{duplicate, missing};
  }
  
  private  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(findNumbers(new int[] {3, 1, 2, 5, 2})));
    System.out.println(Arrays.toString(findNumbers(new int[] {3, 1, 2, 3, 6, 4})));
  }
}
