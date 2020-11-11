package com.kurshit.codeforces.challnges.longer20.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MagnetAndIron {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MagnetAndIron m = new MagnetAndIron();
		try {

			int T = sc.nextInt();

			while(T-- > 0) {
				System.out.println(m.getMaxMagnets(sc));				
			}

		}catch(Exception e) {

		}

	}

//	public static void main(String[] args) {
//		
//		int[] arr = {0,1,2,3,-1};
//		System.out.println(findClosest(arr, 5, 5));
//		
//	}
	
	public int getMaxMagnets(Scanner sc) {

		int N = sc.nextInt();
		int K = sc.nextInt();

		String s = sc.next();

		int[] mArr = new int[N];
		int[] iArr = new int[N];
		Set<Integer> iSet = new HashSet<>();
		int[] xArr = new int[N];
		int[] cArr = new int[N];
		int[] _Arr = new int[N];

		int iPtr = 0;
		int mPtr = 0;
		int xPtr = 0;
		int cPtr = 0;
		int _Ptr = 0;

		int iSize = 0;
		int mSize = 0;
		int xSize = 0;
		int cSize = 0;
		int _Size = 0;


		for(int i=0; i < s.length(); i++) {

			char curr = s.charAt(i);

			switch(curr) {

			case 'M':
				mArr[mPtr] = i;
				mPtr++;
				mSize++;
				break;
			case 'I':
				iArr[iPtr] = i;
				iSet.add(i);
				iPtr++;
				iSize++;
				break;
			case 'X':
				xArr[xPtr] = i;
				xPtr++;
				xSize++;
				break;
			case ':':
				cArr[cPtr] = i;
				cPtr++;
				cSize++;
				break;
			case '_':
				_Arr[_Ptr] = i;
				_Ptr++;
				_Size++;
				break;	

			}			
		}

		int result = 0;
		int iLeftPtr = 0;
		int iRightPtr = iSize - 1;
		
		if(iSize == 0)
			return 0;
		int iIndex = 0;
		for(int i =0; i < mSize; i++) {
	

			int mIndex = mArr[i];
			
			int iArrayActualIndex = findClosest(iArr, iSize, mIndex);
			iIndex = iArr[iArrayActualIndex];
			
			boolean swapped = false;

			
			int xCount = 0;
			if(mIndex > iIndex) {
				xCount = getCountInRange(xArr, xSize, iIndex, mIndex);
			} else {
				xCount = getCountInRange(xArr, xSize, mIndex, iIndex);
			}

			if(xCount > 0)
				continue;

			int sheetCount = getCountInRange(cArr, cSize, mIndex, iIndex);
			int P = K + 1 - Math.abs(iIndex - mIndex) - sheetCount;

			if(P < 0)
				continue;

			if(P >= 1) {
				result ++;
				iArr[iArrayActualIndex] = Integer.MAX_VALUE;							
				Arrays.sort(iArr, 0, iSize);				
				continue;
			}			

			//			if(P == 1) {
			//				if(mIndex < N && s.charAt(mIndex + 1) != ':' || iIndex > 0 && s.charAt(iIndex - 1) != ':') {
			//					result++;
			//					iCurrPtr++;
			//				} else 
			//					continue;
			//			}			

		}		

		return result;

	}

	public int getMaxMagnetsNaive(Scanner sc) {

		int N = sc.nextInt();
		int K = sc.nextInt();

		String s = sc.next();

		Set<Integer> iSet = new HashSet<>();
		int result = 0;

		for(int i=0; i < N; i++) {

			if(s.charAt(i) == 'M') {
				int sheetCount = 0;
				int j = i-1;
				boolean found = false;
				while(j >=0) {

					if(s.charAt(j) == 'X')
						break;

					if(s.charAt(j) == 'M')
						break;

					if(s.charAt(j) == ':')
						sheetCount++;

					if(s.charAt(j) == 'I' && !iSet.contains(j)) {
						int P = K + 1 - Math.abs(j-i) - sheetCount;

						if(P > 0) {
							result++;
							iSet.add(j);
							found = true;
							break;
						}
					}
					j--;
				}
				j = i+1;
				sheetCount = 0;
				while(j < N && !found) {

					if(s.charAt(j) == 'X')
						break;

					if(s.charAt(j) == ':')
						sheetCount++;

					if(s.charAt(j) == 'I' && !iSet.contains(j)) {
						int P = K + 1 - Math.abs(j-i) - sheetCount;

						if(P > 0) {
							result++;
							iSet.add(j);
							break;
						}
					}
					j++;
				}				

			}
		}

		return result;


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

	public static int getCountInRange(int[] arr, int N, int start, int end) {
		return getUpperIndex(arr, N, end) - getLowerIndex(arr, N, start) + 1;
	}

	public static int findClosest(int arr[], int n,  int target) 
	{ 

		// Corner cases 
		if (target <= arr[0]) 
			return 0; 
		if (target >= arr[n - 1]) 
			return n - 1; 

		// Doing binary search  
		int i = 0, j = n, mid = 0; 
		while (i < j) { 
			mid = (i + j) / 2; 

			if (arr[mid] == target) 
				return mid; 

			/* If target is less than array element, 
               then search in left */
			if (target < arr[mid]) { 

				// If target is greater than previous 
				// to mid, return closest of two 
				if (mid > 0 && target > arr[mid - 1])  
					return getClosest(arr, mid - 1,  
							mid, target); 

				/* Repeat for left half */
				j = mid;               
			} 

			// If target is greater than mid 
			else { 
				if (mid < n-1 && target < arr[mid + 1])  
					return getClosest(arr, mid,  
							mid + 1, target);                 
				i = mid + 1; // update i 
			} 
		} 

		// Only single element left after search 
		
		return mid; 
	}

	public static int getClosest(int[] arr, int val1Index, int val2Index,  
			int target) 
	{ 
		if (target - arr[val1Index] >= arr[val2Index] - target)  
			return val2Index;         
		else 
			return val1Index;         
	} 

}
