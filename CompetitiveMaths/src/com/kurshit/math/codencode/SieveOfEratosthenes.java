package com.kurshit.math.codencode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
	
	/*
	 * In the end, we would be left with isPrime array whose values 0 would indicate non prime and 1 would indicate prime
	 * number. Also, primeNumbers array will have all the prime numbers upto N
	 */
	
	public static void main(String[] args) {
		int N = 1000;
		
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		
		sieve.sieve(N);
		
		System.out.println(sieve.primeNumbers);
	}
	
	boolean[] isPrime;  // marked true are prime
	List<Integer> primeNumbers;
	
	public void sieve(int N) {
		isPrime = new boolean[N + 1];
		primeNumbers = new ArrayList<>();
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i =2; i * i <= N; i++) {			
			if(isPrime[i]) {  // if given number is prime
				for( int j = i*i ; j <= N; j +=i) {
					isPrime[j] = false;		// mark all multiple of given prime number as 0 - composite numbers
				}
			}
		} 
		
		for(int i = 0; i <= N; i++) {
			if(isPrime[i]) {
				primeNumbers.add(i);
			}
		}
		
	}

}
