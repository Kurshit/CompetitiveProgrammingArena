package com.codeforces.contests.problemset;

import java.util.Arrays;
import java.util.Scanner;

/*
 *  C Mere array :
 *  
 *  	Example : 
 *  
 *  	4
		1
		8
		6
		4 3 6 6 2 9
		4
		4 5 6 7
		5
		7 5 2 2 4
		
	Output: 
	
		YES
		YES
		YES
		NO
 */

public class Problem1401C {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t  = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			boolean flag = false;
			int[] sorted = arr.clone();
			Arrays.sort(sorted);
			int min = getMin(arr);
			for(int i = 0; i < n; i++) {
				
				if(sorted[i] != arr[i]) {
					if(arr[i] % min != 0 )
					{
						System.out.println("NO");
						flag = true;
						break;
					}					
				}
			}
			
			if(!flag) {
				System.out.println("YES");				
			}
		}		
		sc.close();
		
	}
	
	public static int getMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		
		for(int i =0;i <arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		
		return min;
	}

}
