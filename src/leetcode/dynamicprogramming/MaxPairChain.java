/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 */

public class MaxPairChain {

    public int findLongestChain(int[][] pairs) {



        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int count = 0, end = Integer.MIN_VALUE;
        for (int[] pair : pairs)
        {
            if (pair[0] > end)
            {
                count++;
                end = pair[1];
            }
        }


        return count;

    }


    public static void main(String[] args) {
        MaxPairChain maxPairChain = new MaxPairChain();

//        System.out.println(maxPairChain.findLongestChain(new int[][]{{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}}));
        System.out.println(maxPairChain.findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}}));


    }

}
