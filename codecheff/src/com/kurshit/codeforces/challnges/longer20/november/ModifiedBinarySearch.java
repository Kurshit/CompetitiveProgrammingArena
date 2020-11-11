package com.kurshit.codeforces.challnges.longer20.november;

public class ModifiedBinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 4};
		int start = 4;
		int end = 2;
		int N = 3;
		int count = getUpperIndex(arr, N, end) - getLowerIndex(arr, N, start) + 1;
		System.out.println(count);

	}
	
	public static int getLowerIndex(int[] arr, int N, int start) {
		int l = 0; 
		int h = N-1;
		
		while(l <= h) {
			int mid = (l+h) /2;
			if(arr[mid] >= start)
				h = mid -1;
			else 
				l = mid + 1;
		}
		return l;
		
	}
	
	public static int getUpperIndex(int[] arr, int N, int end) {
		int l = 0; 
		int h = N-1;
		
		while(l <= h) {
			int mid = (l+h) /2;
			if(arr[mid] <= end)
				l = mid  + 1;
			else 
				h = mid - 1;
		}
		return h;
	}

}
