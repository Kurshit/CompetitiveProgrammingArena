package com.kurshit.leetcode.concepts;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorFor2DArray {

	public static void main(String[] args) {
		
		int[] arr = {5,6,8,6,2,3};
		
		Arrays.sort(arr);
		
		for(int i : arr) {
			System.out.print(i+  " ");
		}
		
		System.out.println();
		
		//descending order of first. If first values are equal, sort based on second
		
		int[][] arr2 = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		
		
		Arrays.sort(arr2, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});
		
		for(int[] a : arr2) {
			System.out.println(a[0] + " " +a[1]);
		}
		
		

	}

}
