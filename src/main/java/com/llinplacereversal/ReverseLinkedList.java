package com.llinplacereversal;

// How to prevent head modification of linkedList while reversing
public class ReverseLinkedList {
	
	public static ListNode reverse(ListNode head) {
		if(head == null || head.next == null) // no element or only one element
			return head;
		ListNode currentHead = head; // so that original head is not modified
		ListNode reverse = null;
		ListNode temp = null;
		while(currentHead != null) {
			temp = currentHead;
			currentHead = currentHead.next;
			temp.next = reverse;
			reverse  = temp;
		}
		return reverse;
	}

	public static ListNode reverseOfficial(ListNode head) {
		ListNode current = head; // current node that we will be processing 
		ListNode previous = null; // previous node that we have processed
		ListNode next = null; // will be used to temporarily store the next node
		
		while(current != null) {
			next = current.next; // temporarily store the next node
			current.next = previous; // reverse the current node
			previous = current;	// before we move to the next node, point previous to the current node
			current  = next; // move to the next node
		}
		// after the loop current will be pointing to 'null' and 'previous' will be the new head
		return previous;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		
		ListNode result = ReverseLinkedList.reverse(head);
		System.out.println("Nodes of the reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
		/*
		System.out.println();
		result = ReverseLinkedList.reverseOfficial(head);
		System.out.println("Nodes of the reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
		*/
	}
}
