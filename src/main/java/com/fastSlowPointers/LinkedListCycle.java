package com.fastSlowPointers;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

public class LinkedListCycle {

  public static boolean hasCycle(ListNode listNode) {
    boolean hasCycle = false;
    ListNode firstPointer = listNode, secondPointer = listNode.next;
    while (secondPointer != null ) {
      if (firstPointer == secondPointer) {
        hasCycle = true;
        break;
      }
      firstPointer = firstPointer.next;
      if (secondPointer.next != null) {
        secondPointer = secondPointer.next;
        if (secondPointer.next != null) {
          secondPointer = secondPointer.next;
        } else {
          secondPointer = null;
        }
      } else {
        secondPointer = null;
      }
    }
    return hasCycle;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    System.out.println("LinkedList has cycle:" + hasCycle(head));

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList has cycle:" + hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList has cycle:" + hasCycle(head));
  }
}
