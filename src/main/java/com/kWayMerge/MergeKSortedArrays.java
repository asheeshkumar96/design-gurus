package com.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	public static List<Integer> merge(List<Integer[]> lists) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
				(n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);
		
		for(int i = 0; i < lists.size(); i++)
			if(lists.get(i) != null)
				minHeap.add(new Node(0, i));
		
		List<Integer> resultList = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			int result = lists.get(node.arrayIndex)[node.elementIndex];
			resultList.add(result);
			node.elementIndex++;
			if(lists.get(node.arrayIndex).length > node.elementIndex)
				minHeap.add(node);
		}
		return resultList;
	}

	public static void main(String[] args) {
		Integer[] l1  = new Integer[] {2, 6, 8};
		Integer[] l2 = new Integer[] {3, 6, 7};
		Integer[] l3 = new Integer[] {1, 3, 4};
		List<Integer[]> inputList = new ArrayList<>();
		inputList.add(l1);
		inputList.add(l2);
		inputList.add(l3);
		
		List<Integer> result = MergeKSortedArrays.merge(inputList);
		System.out.print("Here are the elements from the merged list: ");
		for(Integer val : result)
			System.out.print(val + " ");
		System.out.println();
	}
	
}
