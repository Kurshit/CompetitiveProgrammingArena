package com.kurshit.leetcode.pastgoogle;

/*
 * https://leetcode.com/discuss/interview-question/967367/Google-or-on-site-or-find-array-of-integer-is-fit-to-the-other
 * 
 * Problem : Given two arrays a,b with positive integers
	the item i in a represents a server which has a[i] cores.
	the item i in b represents a tasks that needs b[i] cores in order to be execute.
	single server can run multiple tasks but single task can only be execute in single server.
	
	return true if servers can run the tasks and false otherwise.
	
	a = [2,4] b = [1,1,4]
	1,1->2
	4-> 4
	result = true
	a = [1,3] b = [2,2]
	result = false
	a = [8,10] b = [2,3,3,3,7]
	2,3,3->8
	3,7 -> 10
	result = true
 */

public class CoresAndTasks {

	  public static void main(String[] args) {
		    
	        System.out.println(canExecute(new int[]{5,6}, new int[]{3,3,5}, 0)); // true
	        System.out.println(canExecute(new int[]{2,4}, new int[]{1,1,4}, 0)); // true
	        System.out.println(canExecute(new int[]{8,10}, new int[]{2,3,3,3,7}, 0)); //true
	        System.out.println(canExecute(new int[]{1,3}, new int[]{2,2}, 0)); // false
	        System.out.println(canExecute(new int[]{10,15}, new int[]{8,7,6,5}, 0)); // false
	   }

	public static boolean canExecute(int[] cores, int[] tasks, int t){       
	    if(t == tasks.length)
	        return true;
	  
	    for(int i = 0; i < cores.length; i++){
	        if(tasks[t] <= cores[i]){
	            cores[i] = cores[i] - tasks[t];
	            if(canExecute(cores, tasks, t+1))
	                return true;
	            cores[i] = cores[i] + tasks[t];
	        }
	    }
	    
	    return false;
	}

}
 