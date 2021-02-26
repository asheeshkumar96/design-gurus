package com.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianNumberAmongSortedArrays {
	
	public static double findMedian(List<Integer[]> lists) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
				(n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);
		int totalNumberOfElements = 0;
		for(int i = 0; i < lists.size(); i++) {
			minHeap.add(new Node(0, i));
			totalNumberOfElements += lists.get(i).length;
		}
		
		int medianIndex = 0;
		boolean isEvenNumberElements = false;
		// decide median index based on number of elements
		if(totalNumberOfElements % 2 == 1) {
			medianIndex = (totalNumberOfElements / 2) + 1;
		} else {
			medianIndex = totalNumberOfElements / 2;
			isEvenNumberElements = true;
		}
		
		int numberCount = 0; double median = 0;
		while (!minHeap.isEmpty() ) {
			Node node = minHeap.poll();
			median = lists.get(node.arrayIndex)[node.elementIndex];
			if(++numberCount == medianIndex) {
				median = lists.get(node.arrayIndex)[node.elementIndex];
				break;
			}
			node.elementIndex++;
			if(lists.get(node.arrayIndex).length > node.elementIndex)
				minHeap.add(node);
		}
		
		// if even then median = (n/2) +  ( (n /2) + 1 ) / 2
		if(isEvenNumberElements) {
			Node node = minHeap.poll();
			median = (median + lists.get(node.arrayIndex)[node.elementIndex]) / 2;
		}
		return median;
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		double result = MedianNumberAmongSortedArrays.findMedian(lists);
		System.out.println("Median: " + result);

	}

}
