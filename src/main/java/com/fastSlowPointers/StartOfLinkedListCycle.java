package com.fastSlowPointers;

public class StartOfLinkedListCycle {

  public static ListNode findCycleStart(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int cycleLength = 0;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) { // found the cycle
        cycleLength = calculateLength(slow);
        break;
      } // end of if
    }

    fast = head;
    slow = head;
    for (int i = 0; i < cycleLength; i++) {
      fast = fast.next;
    }
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
      if (slow == fast) {
        return slow;
      }
    }

    return head;
  }

  public static int calculateLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;
    do {
      current = current.next;
      cycleLength++;
    } while (slow != current);
    return cycleLength;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start:" + findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start:" + findCycleStart(head).value);
    
    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start:" + findCycleStart(head).value);
  }
}
