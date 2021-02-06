package com.topologicalSort;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
	
	public static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();
		// TODO: Write your own code here
		return sortedOrder;
	}
	
	public static void main(String[] args) {
		// TODO: to fill the values in two dim array
		List<Integer> result = TopologicalSort.sort(4, new int[][] { });
		System.out.println(result);
		
		result = TopologicalSort.sort(5, new int[][] { });;
		System.out.println(result);
		
		result = TopologicalSort.sort(7, new int[][] { });
		System.out.println(result);
	}

}
