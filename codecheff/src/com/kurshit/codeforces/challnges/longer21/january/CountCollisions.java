package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Arrays;
import java.util.Scanner;

public class CountCollisions {


	static public void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt();
			while(T-- > 0) {
				int N = sc.nextInt();
				//String[] s = new String[N];

				//Arrays.fill(s, "");

				int[][] arr = new int[N][];

				for(int i=0; i < N; i++) {

					int M = sc.nextInt();
					int[] temp = new int[M];
					for(int j=0; j < M; j++) {
						temp[j] = sc.nextInt();
					}
					arr[i] = temp;
					Arrays.sort(arr[i]);

					//					for(int j=0; j <M; j++) {
					//						char c = 'R';
					//						if(arr[i][j] < 0) {
					//							c = 'L';
					//						}
					//						
					//						s[i] = s[i] + c; 
					//					}

				}				

				long result = 0;

				for(int[] ss : arr) {
					result = count(ss);
				}

				System.out.println(result);

			}

		} catch(Exception e) {
			
		} finally {
			sc.close();
		}
	}

	//Function to count 
	//no of collision
	static long count(int[] s)
	{
		int N, i; 
		long cnt = 0, ans = 0;

		//length of the string
		N = s.length;
		
		for (i = 0; i < N-1; i++) 
		{
			if(s[i] == s[i+1]) {
				continue;
			}
			
			if (s[i] <= 0)
				cnt++;

			if (s[i] > 0)
				ans += cnt;
		}
		
		if(i == N-1) {
			if(s[i] >=0) {
				ans += cnt;
			}
		}
		return ans;
	}


}

//This code is contributed by Rutvik_56

