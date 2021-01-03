package com.mergeintervals;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
};

// Similar problems
class IntervalOverlap {

	public static boolean overlap(List<Interval> intervals) {

		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		Iterator<Interval> intervalItr = intervals.iterator();
		Interval interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;

		while(intervalItr.hasNext()) {
			interval = intervalItr.next();
			if(interval.start <= end) { // overlapping, adjust the 'end'
				end = Math.max(interval.end, end);
				return true;
			} else {
				// mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// add the last interval
		// mergedIntervals.add(new Interval(start, end))

		return false;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.println(IntervalOverlap.overlap(input));
	}
}