package com.fastSlowPointers;

import com.fastSlowPointers.ListNode;
import java.util.Stack;


public class PalindromicLinkedListUsingStack {

  public static boolean isPalindromic(ListNode head) {
   Stack<Integer> stack = new Stack<Integer>();
   ListNode pointer = head;
   // pushing into linked list
   while (pointer != null) {
     stack.push(pointer.value);
     pointer = pointer.next;
   }
   // popping from stack and matching
   pointer = head;
   while (pointer != null) {
     if(stack.pop() != pointer.value ) {
       return false;
     }
     pointer = pointer.next;
   }
    // if stack is empty after popping the elements
    return true && stack.isEmpty();
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is Palindromic:" + PalindromicLinkedListUsingStack.isPalindromic(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is Palindromic:" + PalindromicLinkedListUsingStack.isPalindromic(head));
  }
}
