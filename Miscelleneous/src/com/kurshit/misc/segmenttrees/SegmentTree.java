package com.kurshit.misc.segmenttrees;


/*
    Source : https://unacademy.com/class/mastering-range-queries-with-segment-trees/C0XZC4BH
    Create a segment tree -

 */

public class SegmentTree {

    public static int[] buildSegmentTree(int[] arr) {
        int[] segtree = new int[4 * arr.length];
        build(arr, segtree, 0, arr.length - 1, 1);
        return  segtree;
    }

    public static void build(int[] arr, int[] tree, int start, int end, int tidx) {

        if(start == end) {
            tree[tidx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(arr, tree, start, mid, 2 * tidx);
        build(arr, tree, mid + 1, end, 2 * tidx + 1);

        tree[tidx] = tree[2 * tidx] + tree[2 * tidx + 1];

    }

    public static void update(int[] arr, int[] tree,  int idx, int val) {
        updateUtil(arr, tree, 0, arr.length-1, 1, idx, val);
    }

    public static void updateUtil(int[] arr, int[] tree, int start, int end, int tidx, int idx, int val) {

        if(start == end) {
            arr[idx] = val;
            tree[tidx] = val;
            return;
        }

        int mid = (start + end) / 2;

        if(idx > mid) {
            updateUtil(arr, tree, mid + 1, end, 2 * tidx + 1, idx, val );
        } else {
            updateUtil(arr, tree, start, mid, 2 * tidx, idx, val );
        }
        //by this time, update would have happened, so update new values going from down to up
        tree[tidx] = tree[2 * tidx] + tree[2 * tidx + 1];

    }

    public static int query(int[] arr, int[] tree,  int left, int right) {
        return queryUtil(arr, tree, 0, arr.length - 1,1, left, right);
    }

    public static int queryUtil(int[] arr, int[] tree, int start, int end, int tidx, int left, int right) {

        if(start > right || end < left) {
            //Completely outside
            return 0;
        }

        if(start >= left && end <= right) {
            //completely inside
            return tree[tidx];
        }

        //partial
        int mid = (start + end)/2;
        int a1 = queryUtil(arr, tree, start, mid, 2 * tidx, left, right);
        int a2 = queryUtil(arr, tree, mid + 1, end, 2 * tidx + 1, left, right);
        return a1 + a2;
    }



    public static void main(String[] args) {

        int[] arr = {2, 3, 3, 4, 5, 7, 8};

        int[] tree = buildSegmentTree(arr);

        for(int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        update(arr, tree, 3, 30);
        System.out.println();

        //after update - {2, 3, 3, 30, 5, 7, 8};

        for(int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();

        System.out.println(query(arr, tree, 1,  5));


    }



}
