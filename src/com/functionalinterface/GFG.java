package com.functionalinterface;
// Java program to generate a random integer
// within this specific range

import java.util.concurrent.ThreadLocalRandom;

class GFG {

	public static int getRandomValue(int Min, int Max)
	{

		// Get and return the random integer
		// within Min and Max
		return ThreadLocalRandom
			.current()
			.nextInt(Min, Max + 1);
	}

	// Driver code
	public static void main(String[] args)
	{

		int Min = 1, Max = 100;

		System.out.println("Random value between "
						+ Min + " and " + Max + ": "
						+ getRandomValue(Min, Max));
	}
}
