package com.mergeintervals;

import com.mergeintervals.Interval2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class Interval2 {
	int start;
	int end;

	public Interval2(int start, int end) {
		this.start = start; 
		this.end = end;
	}
};


class MergeIntervalsOfficial  {
    
    /*
	public static List<Interval2> merge(List<Interval2> intervals) {
		if (intervals.size() < 2) 
			return intervals;

		// sort the intervals by start time
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		List<Interval2> mergedIntervals = new LinkedList<Interval2>();
		Iterator<Interval2> intervalItr = intervals.iterator();
		Interval2 interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;

		while(intervalItr.hasNext()) {
			interval = intervalItr.next();
			if(interval.start <= end) { // overlapping intervals, adjust the 'end'
				end = Math.max(interval.end, end);
			} else { // non-overlapping interval, add the previous interval and reset
				mergedIntervals.add(new Interval2(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// add the last interval
		mergedIntervals.add(new Interval2(start, end));

		return mergedIntervals;
	}
	
	public static void main(String[] args) {
		List<Interval2> input = new ArrayList<Interval2>();
		input.add(new Interval2(1, 4));
		input.add(new Interval2(2, 5));
		input.add(new Interval2(7, 9));
		System.out.print("Merged intervals: ");
		for(Interval2 interval : MergeIntervalsOfficial.merge(input)) {
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		}
		System.out.println();

		input = new ArrayList<Interval2>();
		input.add(new Interval2(6, 7));
		input.add(new Interval2(2, 4));
		input.add(new Interval2(5, 9));
		System.out.print("Merged intervals: ");
		for(Interval2 interval : MergeIntervalsOfficial.merge(input)) {
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		}
		System.out.println();

		input = new ArrayList<Interval2>();
		input.add(new Interval2(1, 4));
		input.add(new Interval2(2, 6));
		input.add(new Interval2(3, 5));
		System.out.print("Merged intervals: ");
		for(Interval2 interval : MergeIntervalsOfficial.merge(input)) {
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		}
		System.out.println();
	}
	*/
}