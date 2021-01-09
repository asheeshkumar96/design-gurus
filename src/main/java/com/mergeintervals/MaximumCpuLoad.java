package com.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCpuLoad {

	public static int findMaxCpuLoad(List<Job> jobs) {
		// sort the jobs by start time
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
		
		int maxCpuLoad = 0, currentCpuLoad = 0;
		PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
		for(Job job: jobs) {
			// remove all jobs that have ended
			while(!minHeap.isEmpty() && job.start > minHeap.peek().end) // why >= not used ??
				currentCpuLoad -= minHeap.poll().cpuLoad;
			
			// add the current job into minHeap
			minHeap.offer(job);
			currentCpuLoad += job.cpuLoad;
			maxCpuLoad = Math.max(maxCpuLoad, currentCpuLoad);
		}
		return maxCpuLoad;
	}
	
	public static void main(String[] args) {
		List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
		System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCpuLoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
		System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCpuLoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
		System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCpuLoad(input));
	}
}
