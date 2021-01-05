package com.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <b>Similar Problem</b><br>
 * Problem 2: Given a list of intervals representing the arrival and departure
 * times of trains to a train station, our goal is to find the minimum number of
 * platforms required for the train station so that no train has to wait.
 * 
 * @author asheesh
 */
public class SimilarMinTrainPlateforms {
	
	public static int minimumRequiredPlatforms(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0)
			return 0;
		
		// sort the intervals by their start
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		
		int minPlateforms = 0;
		PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.size(), (a, b) -> Integer.compare(a.end, b.end));
		for (Interval interval : intervals) {
			// remove all meetings that have ended
			while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end)
				minHeap.poll();
			// add the current meeting into the minHeap
			minHeap.offer(interval);
			// all active meetings are in the minHeap, so we need rooms for all of them
			minPlateforms = Math.max(minPlateforms, minHeap.size());
		}
		return minPlateforms;
	}
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>() {
			{
				add(new Interval(4, 5));
				add(new Interval(2, 3));
				add(new Interval(2, 4));
				add(new Interval(3, 5));
			}
		};
		int result = SimilarMaxIntervalsOverlap.findMaximumIntervalOverlap(input);
		System.out.println("Required platforms: " + result);
		
		input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 4));
				add(new Interval(2, 5));
				add(new Interval(7, 9));
			}
		};
		result = SimilarMaxIntervalsOverlap.findMaximumIntervalOverlap(input);
		System.out.println("Required platforms: " + result);
		
		input = new ArrayList<Interval>() {
			{
				add(new Interval(6, 7));
				add(new Interval(2, 4));
				add(new Interval(8, 12));
			}
		};
		result = SimilarMaxIntervalsOverlap.findMaximumIntervalOverlap(input);
		System.out.println("Required platforms: " + result);
		
		input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 4));
				add(new Interval(2, 3));
				add(new Interval(3, 6));
			}
		};
		result = SimilarMaxIntervalsOverlap.findMaximumIntervalOverlap(input);
		System.out.println("Required platforms: " + result);
		
		input = new ArrayList<Interval>() {
			{
				add(new Interval(4, 5));
				add(new Interval(2, 3));
				add(new Interval(2, 4));
				add(new Interval(3, 5));
			}
		};
		result = SimilarMaxIntervalsOverlap.findMaximumIntervalOverlap(input);
		System.out.println("Required platforms: " + result);
	}
}
