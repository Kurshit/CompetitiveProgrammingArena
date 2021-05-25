package com.kurshit.math.basics;

import java.util.Date;

public class Raw {
	
	
     
     public static void main(String[] args) {
    	 
    	 System.out.println(new Date());
    
    	 int[] arr = {100, 180, 260, 310, 40, 535, 695 }; // 210 + 655 = 865
    	 
    	 int[] arr2 = {100, 80, 260, 310, 40, 535, 695 }; //885
    	 
    	 int[] arr1 = {90, 50, 30, 20 }; // 0
    	 
    	 System.out.println(maxProfit(arr));
    	 System.out.println(maxProfit(arr2));
    	 System.out.println(maxProfit(arr1));
    	 
     }
     
     public static int maxProfit(int[] arr) {
    	 
    	 int maxProfit = 0;
    	 
    	 int N = arr.length;
    	 if(arr.length == 0)
    		 return 0;
    	 
    	 int prev = arr[0]; // buy  	 
    	 
    	 for(int i = 0; i < N-1; i++ ) {
    		     		 
    		 if(arr[i+1] < arr[i]) {
    			 
    			// System.out.println("Bought at " + prev + " and selling at " + arr[i]);
    			 
    			 maxProfit = maxProfit + arr[i] - prev; //210
    			 prev = arr[i+1];
    		 }
    		 
    	 }
    	 
    	 if(arr[N-1] > prev)
    		 maxProfit = maxProfit + arr[N-1] - prev;
    	    	 
    	 
    	 return maxProfit;
    	 
    	 
     }
     
//     public static int[] orderThem(int[] arr) {
//    	 
//    	 int N = arr.length;
//    	 
//    	 int zeros = 0, ones =0, twos =0;
//    	 
//    	 for(int i=0; i < N; i++) {
//    		 
//    		 if(arr[i] == 0) 
//    			 zeros++;
//    		 else if(arr[i] == 1)
//    			 ones++;
//    		 else 
//    			 twos++;
//    	 }
//    	 
//    	 if(arr.length == 0 || zeros == 0 || ones == 0 || twos == 0) {
//    		 return new int[]{};
//    	 }
//    	 
//    	 for(int i = 0; i < N; i++) {
//    		 
//    		 if(zeros != 0) {
//    			 arr[i] = 0;
//    			 zeros--;
//    			 continue;
//    		 }
//    		 
//    		 if(ones != 0) {
//    			 arr[i] = 1;
//    			 ones--;
//    			 continue;
//    		 }
//    		 
//    		 if(twos != 0) {
//    			 arr[i] = 2;
//    			 twos--;
//    			 continue;
//    		 }
//    		 
//    	 }
//    	 
//    	 
//    	 return arr;
//    	 
//    	 
//     }
     
     
}
