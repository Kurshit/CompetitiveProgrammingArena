package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Arrays;
import java.util.Scanner;

public class WIPL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				
				int N = sc.nextInt();
				int K = sc.nextInt();
				
				int[] arr = new int[N];
				
				for(int i=0; i < N; i++) {
					arr[i] = sc.nextInt();
				}
				
				System.out.println(getMinimumBoxes(arr, N, K));
				
				
				
			}
			
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}
	}
	
	public static int getMinimumBoxes(int[] arr, int N, int K) {
		
		Arrays.sort(arr);
		boolean[] visited = new boolean[N];
		
		int end = arr.length - 1;
		
		int sum = 0;
		
		int result = 0;
		
		int j = end - 1;
		boolean isSorted = false;
		while(j >=0 && arr[j] + arr[end] >= K && arr[end] < K ) {
			j--;
			isSorted = true;
		}
		
		visited[end] = true;
		visited[j+1] = true;
		
		if(isSorted) {
			result = 2;
		}
		
		while(!isSorted && sum < K && end >=0) {
			sum = sum + arr[end];
			end = end-1;
		}
				
		if(!isSorted && sum < K) {
			return -1;
		}
		int last = end;
		
		if(!isSorted)
			result = result + (N-end) - 1;
		
		sum = 0;
		int count = 0;
		
		while(sum < K && end >=0) {
			
			if(visited[end]) {
				end--;
				continue;
			} else {
				sum = sum + arr[end];
				end--;
				count++;
			}
				
			
			
		}
		
		if(sum < K) {
			return -1;
		}
		
		result = result + count; 
		
		return result;
	}
	

}
