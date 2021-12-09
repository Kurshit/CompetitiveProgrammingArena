package com.kurshit.leetcode.googletagged.bfs;

/*
    Problem : Rotting Oranges #994
    Statement: You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4
    Example 2:

    Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    Example 3:

    Input: grid = [[0,2]]
    Output: 0
    Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {

//        int[][] grid = {
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}
//        };

        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        RottingOranges r = new RottingOranges();

        System.out.println(r.orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {

        Queue<OPair> queue = new LinkedList<>();
        int M = grid.length;
        int N = grid[0].length;
        int totalFreshOranges = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new OPair(i, j));
                } else if (grid[i][j] == 1) {
                    totalFreshOranges++;
                }
            }
        }

        if(totalFreshOranges == 0)
            return 0;

        int minutes = -1;

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                OPair pair = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int neighbourRow = pair.i + dir[i][0];
                    int neighbourCol = pair.j + dir[i][1];

                    if (isSafe(grid, M, N, neighbourRow, neighbourCol)) {
                        if (grid[neighbourRow][neighbourCol] == 1) {
                            grid[neighbourRow][neighbourCol] = 2; //rott the fresh orange
                            queue.offer(new OPair(neighbourRow, neighbourCol));
                            totalFreshOranges--;
                        }
                    }

                }

            }

            minutes++;
        }

        return totalFreshOranges == 0 ? minutes : -1;

    }

    private boolean isSafe(int[][] grid, int M, int N, int neighbourRow, int neighbourCol) {

        if (neighbourRow >= 0 && neighbourRow < M && neighbourCol >= 0 && neighbourCol < N)
            return true;

        return false;
    }

    class OPair {
        int i;
        int j;

        public OPair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
