package com.llinplacereversal;


public class ReverseEveryKElements {
	
	public static ListNode reverse(ListNode head, int k) {
		if(head == null || k == 0 || k == 1) // when the sublist will be of size one, the final sublist will be same as original
			return head;
		
		ListNode current = head;
		ListNode finalList = null;
		ListNode lastNodeInFinal = null;
		while(current != null) {
			// System.out.println(current.value + " ");
			int counter = 0;
			ListNode lastNodeOfSublist = current;
			ListNode sublist = current;
			ListNode temp = null;
			while(current != null && counter < k) {
				// System.out.println("Inside innter loop, value = " + current.value);
				temp = current.next;
				current.next = sublist;
				sublist = current;
				current = temp;
				counter++;
			}
			if(current == null) {
				// System.out.println("terminating list");
				lastNodeOfSublist.next = null;
			}
			
			if(finalList == null) {
				finalList = sublist;
				lastNodeInFinal = lastNodeOfSublist;
				// System.out.println("final list null");
			} else {
				lastNodeInFinal.next = sublist;
				lastNodeInFinal = lastNodeOfSublist;
				// System.out.println("final list not null," + " lastNodInFinal=" + lastNodeInFinal.value);
			}
		}
		
		return finalList;
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
		
		ListNode result = ReverseEveryKElements.reverse(head, 2);
		System.out.println("Nodes of reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
