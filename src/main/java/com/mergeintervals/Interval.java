package com.mergeintervals;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public String toString() {
    return "[" + start + ", " + end + "] ";
  }
}
