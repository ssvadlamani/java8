package com.functionalinterface;
class Recu {

	public static int sum(int n)
	{
		if(n<=0) {
			return 0;
		}
		// Get and return the random integer
		// within Min and Max
		return n+sum(n-1);
	}
	
	public static int sumPair(int n)
	{
		int sum = 0;
		if(n>0) {
			for(int i=1;i<=n;i++) {
				sum = sum+pairsum(i,i+1) ;
			};
		}
		return sum;
	
	}


	
	public static int pairsum(int a,int b)
	{	// Get and return the random integer
		// within Min and Max
		return a+b;
	}
	// Driver code
	public static void main(String[] args)
	{
		int i = sumPair(5);

		
		System.out.println(i);
	}
	}
