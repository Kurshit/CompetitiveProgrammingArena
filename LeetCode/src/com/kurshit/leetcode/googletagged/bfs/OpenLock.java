package com.kurshit.leetcode.googletagged.bfs;

/*
    Problem : Open the lock #752
    Solution Src : https://www.youtube.com/watch?v=IHT8Sx0832k
    Problem Statement : You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

    The lock initially starts at '0000', a string representing the state of the 4 wheels.

    You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

    Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

    Example:

        Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
        Output: 6
        Explanation:
        A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
        Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
        because the wheels of the lock become stuck after the display becomes the dead end "0102".

    Example :

        Input: deadends = ["8888"], target = "0009"
        Output: 1
        Explanation:
        We can turn the last wheel in reverse to move from "0000" -> "0009".

 */


import java.util.*;

public class OpenLock {

    public static void main(String[] args) {

        //List<String> list = Arrays.asList("0201","0101","0102","1212","2002");
        List<String> list = Arrays.asList("8888");
        String[] arr = list.toArray(new String[list.size()]);
        //String target = "0202";
        String target = "0009";
        System.out.println(openLock(arr, target));
    }

    public static int openLock(String[] deadends, String target) {

        Queue<String> queue = new LinkedList<>();
        Set<String> deadSet = new HashSet(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        queue.offer("0000");

        visited.add("0000");

        int result = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-- > 0) {
                String currLock = queue.poll();

                if(deadSet.contains(currLock)) {
                   continue;
                }

                if(currLock.equals(target)) {
                    return result;
                }

                StringBuilder sb = new StringBuilder(currLock);

                for(int i = 0; i < 4; i++) {

                    char currPosition = sb.charAt(i);
                    //one S1 for inc and S2 for dec

                    String s1 = sb.substring(0, i) + (currPosition == '9' ? 0 : (currPosition - '0') + 1) + sb.substring(i + 1);

                    String s2 = sb.substring(0, i) + (currPosition == '0' ? 9 : (currPosition - '0') - 1) + sb.substring(i + 1);

                    if(!visited.contains(s1) && !deadSet.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }

                    if(!visited.contains(s2) && !deadSet.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }

            }

            result++;
        }


        return -1;
    }
}
