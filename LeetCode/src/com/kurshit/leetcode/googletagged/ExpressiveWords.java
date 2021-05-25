package com.kurshit.leetcode.googletagged;

/*
 * Problem Source: https://leetcode.com/problems/expressive-words/solution/
 * 
 * Problem : Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  
 * In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

 *	For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the 
 *following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.
	
 *	For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" 
 * since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  
 * If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: 
 * query = "hello" -> "hellooo" -> "helllllooo" = S.
	
 *	Given a list of query words, return the number of words that are stretchy.
 *
 * S = "heeellooo"
 *	words = ["hello", "hi", "helo"]
	Output: 1
	Explanation: 
	We can extend "e" and "o" in the word "hello" to get "heeellooo".
	We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

 *
 */

import java.util.ArrayList;
import java.util.List;

class ExpressiveWords {
   
	/*
	 * For some word, write the head character of every group, and the count of that group. 
	 * For example, for "abbcccddddaaaaa", we'll write the "key" of "abcda", and the "count" [1,2,3,4,5].

		Let's see if a word is stretchy. Evidently, it needs to have the same key as S.
		
		Now, let's say we have individual counts c1 = S.count[i] and c2 = word.count[i].
		
		1. key has to be same for S and words
		2. If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters.
		
		3. If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S, as the latter is extended.
		
		4. Else, if c1 < 3, 
				4.1 then we must have c2 == c1 for the ith groups of word and S to match.
		
		
	 */
	
	
	public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }
}

class RLE {
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || ca[i] != ca[i+1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }

        key = sb.toString();
    }
}