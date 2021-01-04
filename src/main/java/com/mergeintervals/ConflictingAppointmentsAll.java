package com.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConflictingAppointmentsAll {
	
	public static List<Interval[]> conflictingAppointments(Interval[] intervals) {
		List<Interval[]> conflictingAppointments = new ArrayList<Interval[]>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		// find any overlapping appointment
		
		// Prove that these two loops can not be replaced with single loop ? 
		for(int i = 0; i < intervals.length - 1; i++) {
			int j = i + 1;
			while(j < intervals.length) {
				if(intervals[j].start < intervals[i].end) {
					Interval[] conflicts = new Interval[2];
					conflicts[0] = intervals[j];
					conflicts[1] = intervals[i];
					conflictingAppointments.add(conflicts);
				}
				j++;
			}
		}
		System.out.println("Conflicting appointments:" + conflictingAppointments);
		return conflictingAppointments;
	}

	public static void main(String[] args) {
		Interval[] intervals = { 
				new Interval(4, 5), 
				new Interval(2, 3), 
				new Interval(3, 6), 
				new Interval(5, 7), 
				new Interval(7, 8)
				};
		for(Interval[] element : ConflictingAppointmentsAll.conflictingAppointments(intervals)) {
			System.out.println( element[0] + " and " + element[1] + " conflict");
		}
	}
}
