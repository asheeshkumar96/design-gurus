package com.llinplacereversal;

public class RotateList {
	
	public static ListNode rotate(ListNode head, int rotations) {
		if(head == null || head.next == null)
			return head;
		
		int lengthOfLinkedList = 0;
		ListNode current = head;
		while(current != null) {
			lengthOfLinkedList++;
			current = current.next;
		}
		// Effective rotations, in case if rotations are greater than the length of linked list
		rotations = rotations % lengthOfLinkedList;
		if(rotations == 0) //
			return head;
		
		ListNode beforeEnd = head;
		// Successfull iterations = length - k
		for(int i = 0; i < lengthOfLinkedList - rotations - 1; i++) {
			beforeEnd = beforeEnd.next;
		}
		
		ListNode lastPartOfLinkedList = beforeEnd.next;
		beforeEnd.next = null;
		current = lastPartOfLinkedList;
		while(current.next != null) {
			current = current.next;
		}
		current.next = head;
		
		return lastPartOfLinkedList;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		ListNode result = RotateList.rotate(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
		System.out.println();
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		result = RotateList.rotate(head, 8);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while(result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
		System.out.println();
	}

}
