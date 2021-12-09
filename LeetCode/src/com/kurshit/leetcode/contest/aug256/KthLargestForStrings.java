package com.kurshit.leetcode.contest.aug256;

import java.math.BigInteger;
import java.util.Arrays;

public class KthLargestForStrings {

    public static void main(String[] args) {
        String[] str = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        int k = 2;
        System.out.println(kthLargestNumber(str, k));
    }

    public static String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums, (first, second) -> {

                if(first.length() ==second.length())
                    return second.compareTo(first);
                else
                    return second.length() - first.length();

            });

            return nums[k-1];
    }


}
