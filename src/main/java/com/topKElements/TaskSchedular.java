package com.topKElements;

public class TaskSchedular {
	
	public static int scheduleTasks(char[] tasks, int k) {
		return -1;
	}

	public static void main(String[] args) {
		char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskSchedular.scheduleTasks(tasks, 2));
		
		tasks = new char[] { 'a', 'b', 'a' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskSchedular.scheduleTasks(tasks, 3));
	}
}
