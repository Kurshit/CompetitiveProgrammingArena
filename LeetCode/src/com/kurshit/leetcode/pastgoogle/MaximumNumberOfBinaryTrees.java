package com.kurshit.leetcode.pastgoogle;

/*
 * Problem Source : https://leetcode.com/discuss/interview-question/902649/Google-or-Phone-or-Unique-Binary-Search-Trees
 * 
 * Solution : https://www.geeksforgeeks.org/program-nth-catalan-number/
 */

public class MaximumNumberOfBinaryTrees {

	public static void main(String[] args) {
		int N = 3;
		System.out.println(catalan(N));

	}
	
	public static int catalan(int n) 
    { 
        int res = 0; 
  
        // Base case 
        if (n <= 1)  
        { 
            return 1; 
        } 
        for (int i = 0; i < n; i++)  
        { 
            res += catalan(i)  
                * catalan(n - i - 1); 
        } 
        return res; 
    } 

}
