package com.codeforces.contests.div3.may719;

import java.util.Scanner;

public class ProblemB {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		try {
			while(T-- > 0 ) {
				
				int N = sc.nextInt();
				
				System.out.println(pre(1, N));
				
				
			}
		}catch(Exception e) {
			
		}
		
		
		sc.close();
	}
	
	public static int pre(int L, int R) {
		 int tmp = 0, ans = 0;
		  
		    // Length of R
		    int n = (int)Math.log10(R) + 1;
		  
		    for(int i = 0; i < n; i++)
		    {
		         
		       // tmp has all digits as 1
		       tmp = tmp * 10 + 1;
		         
		       // For each multiple of tmp 
		       // in range 1 to 9, check if
		       // it present in range [L, R]
		       for(int j = 1; j <= 9; j++)
		       {
		          if (L <= (tmp * j) && (tmp * j) <= R) 
		          {
		              // Increment the required count
		              ans++;
		          }
		       }
		    }
		    return ans;
		
	}

	
}

