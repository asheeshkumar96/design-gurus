package com.mergeintervals;

public class EmployeeInterval {

	Interval interval;
	int employeeIndex;
	int intervalIndex;
	
	public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
		this.interval = interval;
		this.employeeIndex = employeeIndex; 
		this.intervalIndex = intervalIndex;
	}
}
