package com.llinplacereversal;

public class ReverseEveryKElementsOfficial {
	
	public static ListNode reverse(ListNode head, int k) { 
		if(k <= 1 || head == null)
			return head;
		
		ListNode current = head, previous = null;
		while(true) {
			ListNode lastNodeOfPreviousPart = previous;
			// after reversing the LinkedList 'current' will become the last node of sub-list
			ListNode lastNodeOfSublist = current;
			ListNode next = null; // will be used to temporarily store the next node
			// reverse 'k' nodes
			for(int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			
			// connect with the previous part 
			if(lastNodeOfPreviousPart != null)
				lastNodeOfPreviousPart.next = previous;
			else
				head = previous;
			
			// connect with the next part
			lastNodeOfSublist.next = current;
			
			if(current == null) // break, if we've reached the end of the LinkedList
				break;
			// prepare for the next sub-list
			previous = lastNodeOfSublist;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode result = ReverseEveryKElementsOfficial.reverse(head, 3);
		System.out.println("Nodes of reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
