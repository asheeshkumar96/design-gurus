package com.topKElements;

public class FrequencyStack {
	
	public void push(int num) { 
		
	}
	
	public int pop() {
		return -1;
	}

	public static void main(String[] args) {
		FrequencyStack frequencyStack = new FrequencyStack();
		frequencyStack.push(1);
		frequencyStack.push(1);
		frequencyStack.push(1);
		frequencyStack.push(1);
		frequencyStack.push(1);
		frequencyStack.push(1);
		frequencyStack.push(1);
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
	}

}
