package com.fastSlowPointers;

public class HappyNumberOfficial {

  public static boolean find(int num) {
    int slow = num, fast = num;
    do {
      slow = findSquareSum(slow);
      fast = findSquareSum(fast);
    } while (slow != fast);
    
    return  slow == 1;
  }
  
  private static int findSquareSum(int num) {
    int sum = 0, digit;
    while (num > 0) {
      digit = num % 10;
      sum += digit * digit;
      num /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
  }
}
