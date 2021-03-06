package com.fastSlowPointers;

public class HappyNumber {

  public static boolean find(int num) {
    int slow = num, fast = num;
    do {
      slow = sumOfSquaresOfDigits(slow); // move one step
      fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast)); // move two steps
    } while (slow != fast);
    return slow == 1;
  }
  
  private static int sumOfSquaresOfDigits(int num) {
    int sum = 0;
    while (num > 0) {
      int digit = num % 10;
      sum += (digit * digit);
      num /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
  }
}
