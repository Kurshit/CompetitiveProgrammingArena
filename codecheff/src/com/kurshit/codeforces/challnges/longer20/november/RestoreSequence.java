package com.kurshit.codeforces.challnges.longer20.november;

import java.util.Scanner;

public class RestoreSequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			RestoreSequence r = new RestoreSequence();
			
			int T =sc.nextInt();
			
			while(T-- > 0) {
				int N = sc.nextInt();
				int[] arr = new int[N+1];
				
				for(int i=1; i <=N; i++) {
					arr[i] = sc.nextInt();
				}
				
				r.solve(arr, N);
				System.out.println();
			}

		}catch(Exception e ) {
			
		} finally {
			sc.close();
		}

	}
	
	public void solve(int[] arr, int N) {
		
		int[] result = new int[N+1];
		
		int nextPrime = 3;
		
		for(int i =1; i <= N; i++) {
			
						
			if(arr[i] == i) {
				if(result[i] != 0) {
					continue;
				}
				result[i] = nextPrime;
				nextPrime = nextPrime(nextPrime);
			} else {
				int index = arr[i];
				
				if(result[index] != 0) {
					result[i] = result[index];
					continue;
				}
				result[index] = nextPrime;
				result[i] = nextPrime;
				nextPrime = nextPrime(nextPrime);
			}
		}
		
		for(int i =1; i <=N; i++) {
			System.out.print(result[i] + " ");
		}
		
		
	}
	
	int nextPrime(int N)  
    {  
      
        // Base case  
        if (N <= 1)  
            return 2;  
      
        int prime = N;  
        boolean found = false;  
      
        // Loop continuously until isPrime returns  
        // true for a number greater than n  
        while (!found)  
        {  
            prime++;  
      
            if (isPrime(prime))  
                found = true;  
        }  
      
        return prime;  
    }
	
	boolean isPrime(int n)  
    {  
        // Corner cases  
        if (n <= 1) return false;  
        if (n <= 3) return true;  
          
        // This is checked so that we can skip  
        // middle five numbers in below loop  
        if (n % 2 == 0 || n % 3 == 0) return false;  
          
        for (int i = 5; i * i <= n; i = i + 6)  
            if (n % i == 0 || n % (i + 2) == 0)  
            return false;  
          
        return true;  
    }  
	
	private int gcd(int a, int b)
    {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }

}
