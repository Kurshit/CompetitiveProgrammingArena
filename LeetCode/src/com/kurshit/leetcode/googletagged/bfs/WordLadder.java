package com.kurshit.leetcode.googletagged.bfs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> dictList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(wordLadderBFS(beginWord, endWord, dictList));

        beginWord = "hit";
        endWord = "cog";

        List<String> dictList1 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(wordLadderBFS(beginWord, endWord, dictList1));


    }

    public static int wordLadderBFS(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>();

        for(String word : wordList) {
            dict.add(word);
        }

        Queue<String> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size-- > 0) {

                String curr = queue.poll();

                for(int i =0; i < curr.length(); i++) {

                    char[] temp = curr.toCharArray();

                    for(char c = 'a'; c <= 'z'; c++) {
                        temp[i] = c;

                        String tempTarget = new String(temp);

                        if(tempTarget.equals(curr))
                            continue;

                        if(tempTarget.equals(endWord) && dict.contains(tempTarget)) {
                            return level + 1;
                        }

                        if(dict.contains(tempTarget)) {
                            queue.offer(tempTarget);
                            dict.remove(tempTarget);
                        }
                    }
                }

            }


        }
        return 0;
    }
}
