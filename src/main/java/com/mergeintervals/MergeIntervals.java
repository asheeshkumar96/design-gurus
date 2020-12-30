package com.mergeintervals;

import com.mergeintervals.MergeIntervals;
import java.util.ArrayList;
import java.util.List;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    List<Interval> mergedIntervals = new ArrayList<Interval>();

    return mergedIntervals;
  }

  public static void main(String[] args) {

    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merge Intervals: ");
    for (Interval interval : MergeIntervals.merge(input)) {
      System.out.print(" [ " + interval.start + ", " + interval.end + " ] ");
    }
    System.out.println();
  }
}
