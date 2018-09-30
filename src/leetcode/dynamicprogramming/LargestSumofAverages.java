/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.Arrays;

public class LargestSumofAverages {

    public double largestSumOfAverages(int[] A, int K) {

        int[] sums = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            sums[i] = A[i] + ((i > 0) ? sums[i - 1] : 0);
        }

        double dp[][] = new double[A.length][K+1];


        return largestSumOfAverages(A, sums, dp, K, 0, A.length);
    }


    public double largestSumOfAverages(int[] A, int[] sums, double[][] dp, int K, int start, int len) {


        if(dp[start][K] !=0) return dp[start][K];

        if (K == 1) {
            dp[start][K] = ((double) (sums[len - 1] - sums[start] + A[start]) / (len - start));
            return dp[start][K];
        }

        for (int i = start; i + K <= len; i++) {
            dp[start][K] = Math.max(dp[start][K], ((double) (sums[i] - sums[start] + A[start]) / (i - start + 1)) + largestSumOfAverages(A, sums,dp, K - 1, i + 1, len));


        }

        return dp[start][K];
    }


    public static void main(String[] args) {
        System.out.println(new LargestSumofAverages().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }
}
