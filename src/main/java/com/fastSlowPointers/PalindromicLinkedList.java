package com.fastSlowPointers;

public class PalindromicLinkedList {

  public static boolean isPalindromic(ListNode head) {
    // check that the linked list is palindromic
    return false;
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
