package com.llinplacereversal;

public class ReverseSubList {
	
	public static ListNode reverse(ListNode head, int p, int q) {
		ListNode currentHead = head;
		int i = 1;
		
		ListNode firstUnchangedPart = currentHead;
		while(currentHead != null && i < p  - 1) {
			firstUnchangedPart.next = currentHead;
			currentHead = currentHead.next;
			i++;
		}
		
		ListNode reversedPart = null;
		ListNode temp = null;
		ListNode otherEndOfReversedPart = null;
		while(currentHead != null && i <= q) {
			temp = currentHead;
			if(i == p) {
				otherEndOfReversedPart = temp;
			}
			currentHead = currentHead.next;
			temp.next = reversedPart;
			reversedPart = temp;
			i++;
		}
		firstUnchangedPart.next = reversedPart;
		otherEndOfReversedPart.next = currentHead;
		
		return firstUnchangedPart;
		
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode result = ReverseSubList.reverse(head, 2, 4);
		System.out.println("Nodes of the reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
