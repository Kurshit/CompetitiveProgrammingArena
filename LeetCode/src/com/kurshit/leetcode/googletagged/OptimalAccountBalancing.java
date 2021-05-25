package com.kurshit.leetcode.googletagged;

/*
 * Problem Source : https://leetcode.com/problems/optimal-account-balancing/
 * 
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

	Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
	
	Note:
	
	A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
	Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
	
	Example : Input:
			[[0,1,10], [2,0,5]]
			
			Output:
			2
			
			Explanation:
			Person #0 gave person #1 $10.
			Person #2 gave person #0 $5.
			
			Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {

	public static void main(String[] args) {
		
		int[][] arr = {{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}};
		OptimalAccountBalancing o = new OptimalAccountBalancing();
		System.out.println(o.minTransfers(arr));
		
		/*
		 * 1

			Explanation:
			Person #0 gave person #1 $10.
			Person #1 gave person #0 $1.
			Person #1 gave person #2 $5.
			Person #2 gave person #0 $5.
			
			Therefore, person #1 only need to give person #0 $4, and all debt is settled.

		 */

	}
	
	int res = Integer.MAX_VALUE;
    
	public int minTransfers(int[][] transactions) {
        
		Map<Integer, Integer> map = new HashMap<>();
    
        for (int[] tran : transactions) {
            int a = tran[0];
            int b = tran[1];
            int v = tran[2];
            
            map.put(a, map.getOrDefault(a, 0) + v);
            map.put(b, map.getOrDefault(b, 0) - v);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int e : map.values()) {
            if (e != 0) list.add(e);
        }
        
        dfs(list, 0, 0);
        
        return res;
    }
    
    private void dfs(List<Integer> list, int sum, int zeroCnt) {        
        if (zeroCnt == list.size()) {
            res = Math.min(res, sum);
            return;
        }
        if (sum > res) return;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                
                int a = list.get(i);
                list.set(i, 0);
                
                for (int j = i + 1; j < list.size(); j++) {
                    int b = list.get(j);
                    if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
                        int c = b + a;
                        list.set(j, c);
                        dfs(list, sum + 1, 1 + zeroCnt + (c==0? 1:0));
                        
                        list.set(j, b);
                    }
                }
                
                list.set(i, a);
                break;
            }
        }
        
    }

}
