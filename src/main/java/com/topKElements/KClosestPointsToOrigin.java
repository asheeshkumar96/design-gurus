package com.topKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point {
	int x; 
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int distFromOrigin() {
		// ignoring sqrt
		return (x * x) + (y * y);
	}
}

public class KClosestPointsToOrigin {
	
	// also official
	public static List<Point> findClosestPoints(Point[] points, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>( (p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
		// put first 'k' points in the max heap
		for(int i = 0; i < k; i++)
			maxHeap.add(points[i]);
		
		// go through the remaining points
		for(int i = k; i < points.length; i++) {
			if(points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
				maxHeap.poll();
				maxHeap.add(points[i]);
			}
		}
		
		// the heap has 'k' points closest to the origin, return them in a list
		return new ArrayList<>(maxHeap);
	}

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1)};
		List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
		System.out.print("Here are the k points closest to origin: ");
		for(Point p : result)
			System.out.print("[" + p.x + ", " + p.y + "] ");
	}
}
