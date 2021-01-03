package com.mergeintervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class MergeIntervals {
  
  /*
  public static List<Interval> merge(List<Interval> intervals) {
    // If passed intervals size is one or less than one , return
    if(intervals.size() <= 1) {
      return intervals;
    }
    // Sort the intervals
    Collections.sort(intervals, (interval1, interval2) -> Integer.compare(interval1.start, interval2.start));
    System.out.println("Intervals after sorting:" + intervals);
    List<Interval> mergedIntervals = new ArrayList<Interval>();
    Interval currentInterval = intervals.get(0);
    mergedIntervals.add(currentInterval); 
    
    for(Interval interval: intervals) {
      int currentStart = currentInterval.start;
      int currentEnd = currentInterval.end;
      int nextStart = interval.start;
      int nextEnd = interval.end;

      if(currentEnd >= nextStart) {
        currentInterval.end = Math.max(currentEnd, nextEnd);
      } else {
        currentInterval = interval;
        mergedIntervals.add(currentInterval);
      }
    }

    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merge Intervals: ");
    for (Interval interval : MergeIntervals.merge(input)) {
      System.out.print("[ " + interval.start + ", " + interval.end + " ] ");
    }
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merge Intervals: ");
    for (Interval interval : MergeIntervals.merge(input)) {
      System.out.print("[ " + interval.start + ", " + interval.end + " ] ");
    }
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merge Intervals: ");
    for (Interval interval : MergeIntervals.merge(input)) {
      System.out.print("[ " + interval.start + ", " + interval.end + " ] ");
    }
    System.out.println();
  }
  */
}
