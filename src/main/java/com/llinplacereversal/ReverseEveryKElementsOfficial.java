package com.llinplacereversal;

public class ReverseEveryKElementsOfficial {
	
	public static ListNode reverse(ListNode head, int k) { 
		if(k <= 1 || head == null)
			return head;
		
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
		
		ListNode result = ReverseEveryKElementsOfficial.reverse(head, 2);
		System.out.println("Nodes of reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
