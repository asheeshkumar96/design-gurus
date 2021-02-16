package com.subsets;

class CountUniqueTrees {
	
	// calculates and returns 'n'th catalan number.
	public int countTrees(int n) {
		int nFactorial = 1;
		// calculating n!
		for(int i = 1; i <= n; i++) {
			nFactorial *= i;
		}
		
		// calculating (2n!)
		int twoNFactorial = nFactorial;
		for(int i = 1; i <= n; i++) {
			twoNFactorial *= (n + i);
		}
		// calculating the formula for catalan number, (2n)! / (n+1)! * n! or (2n)! / n! * n! * (n+1)
		return twoNFactorial / (nFactorial * (n + 1) * nFactorial);
	}	

	public static void main(String[] args) {
		CountUniqueTrees ct = new CountUniqueTrees();
		int count = ct.countTrees(3);
		System.out.println("Total trees: " + count);
	}
}
