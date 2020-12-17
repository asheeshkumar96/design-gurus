package com.fastSlowPointers;

import com.fastSlowPointers.ListNode;

public class PalindromicLinkedList {

  // linked list palindrome check using by reversing the other half
  public static boolean isPalindromic(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    // find middle of the linked list
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode headSecondHalf = reverse(slow);
    ListNode copyHeadSecondHalf = headSecondHalf;

    // compare the first and the second half
    while (head != null && headSecondHalf != null) {
      if (head.value != headSecondHalf.value) {
        break; // not a palindrome
      }
      head = head.next;
      headSecondHalf = headSecondHalf.next;
    }

    reverse(copyHeadSecondHalf); // reverse the reverse of second half
    if (head == null || headSecondHalf == null) {
      return true;
    }
    return false;
  }

  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is Palindromic:" + PalindromicLinkedList.isPalindromic(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is Palindromic:" + PalindromicLinkedList.isPalindromic(head));
  }
}
