package com.kurshit.leetcode.googletagged.dp;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(hasWordDP(s, wordDict));

    }

    /*
        Approach 1 : Using DP - O(N3)

        N3 - as inside two for loops, it uses substring which takes O(N) - N - Length

     */

    public static boolean hasWordDP(String s, List<String> wordDict) {
        int N = s.length();
        Set<String> dictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // works even when not given
                }
            }
        }

        return dp[N];
    }

    /*
        Approach 2 : Using BFS - O(N3)

     */

    public static boolean hasWordBFS(String s, List<String> wordDict) {

        Set<String> dictSet = new HashSet<>(wordDict);
        int N = s.length();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(0);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            if(visited[curr]) {
                continue;
            }

            for(int end = curr + 1; end <= s.length(); end++) {
                if(dictSet.contains(s.substring(curr, end))) {
                    queue.offer(end);

                    if(end == s.length()) {
                        return true;
                    }
                }
            }

            visited[curr] = true;
        }

        return false;
    }

}
