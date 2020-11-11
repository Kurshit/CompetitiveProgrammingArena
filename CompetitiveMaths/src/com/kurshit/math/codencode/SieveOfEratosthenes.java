package com.kurshit.math.codencode;

public class SieveOfEratosthenes {
	
	/*
	 * In the end, we would be left with isPrime array whose values 0 would indicate non prime and 1 would indicate prime
	 * number.
	 */
	
	
	public void sieve() {
		int maxN = 1000000; 		//1 million
		int[] isPrime = new int[maxN];  // marked 1/true are prime
		
		for(int i =1; i <= maxN; i++) 
			isPrime[i] = 1;
		
		isPrime[0] = 0;
		isPrime[1] = 0;
		
		for(int i =2; i * i <= maxN; i++) {			
			if(isPrime[i] == 1) {  // if given number is prime
				for( int j = i*i ; j <= maxN; j++) {
					isPrime[i] = 0;		// mark all multiple of given prime number as 0 - composite numbers
				}
			}
		}
		
	}

}
