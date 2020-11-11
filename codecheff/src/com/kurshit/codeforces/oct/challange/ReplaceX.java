package com.kurshit.codeforces.oct.challange;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceX {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            long t = sc.nextInt();
            while (t-- > 0) {
                int length = sc.nextInt();
                int element = sc.nextInt();
                int targetPos = sc.nextInt();
                int replaceablePos = sc.nextInt();

                int[] arr = new int[length];
                for (int i = 0; i < length; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println(solve(length, element, targetPos, replaceablePos, arr));
            }
        } catch (Exception e) {

        } finally {
            sc.close();
        }
    }

	static int solve(int length, int element, int targetPos, int replaceablePos, int[] arr) {
        Arrays.sort(arr);
        int actualTargetPos = targetPos - 1;
        if (arr[actualTargetPos] == element) {
            return 0;
        }
        int currPositionOfElement = Arrays.binarySearch(arr, element);
        if (currPositionOfElement >= 0 &&
                ((currPositionOfElement < actualTargetPos && replaceablePos < targetPos) || (currPositionOfElement > actualTargetPos && replaceablePos > targetPos))) {
            return -1;
        }
        if (replaceablePos >= targetPos && element < arr[actualTargetPos]) {
            if (currPositionOfElement < 0) {
                if (element < arr[0]) {
                    return targetPos;
                }
                int i = 1;
                while (i <= actualTargetPos) {
                    if (arr[actualTargetPos - i] < element) {
                        return i;
                    }
                    i++;
                }
            } else {
                return actualTargetPos - currPositionOfElement;
            }
        }
        if (replaceablePos <= targetPos && element > arr[actualTargetPos]) {
            if (currPositionOfElement < 0) {
                if (element > arr[length - 1]) {
                    return length - actualTargetPos;
                }
                int i = 1;
                while (actualTargetPos + i < length) {
                    if (arr[actualTargetPos + i] > element) {
                        return i;
                    }
                    i++;
                }
            } else {
                return currPositionOfElement - actualTargetPos;
            }
        }
        return -1;
    }
}
