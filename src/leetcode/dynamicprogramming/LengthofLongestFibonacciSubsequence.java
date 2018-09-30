/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * <p>
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 * <p>
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 * <p>
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 */

public class LengthofLongestFibonacciSubsequence {

    public static void main(String[] args) {

        System.out.println(new LengthofLongestFibonacciSubsequence().lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        System.out.println(new LengthofLongestFibonacciSubsequence().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));


    }

    public int lenLongestFibSubseq(int[] A) {

        int len = A.length;
        Set<Integer> numSet = new HashSet<>();

        Arrays.stream(A).forEach(i -> numSet.add(i));

        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {


                int tempLen = 2;

                int i_0 = A[i];
                int i_1 = A[j];
                int i_2 = i_0 + i_1;

                while (numSet.contains(i_2)) {
                    int temp = i_2;
                    i_2 += i_1;
                    i_1 = temp;

                    maxLen = Math.max(maxLen, ++tempLen);
                }


            }

        }

        return maxLen;


    }

    boolean isFactorial(int[] A, int i, int i_1, int i_2) {
        if (i < 0) {
            return true;
        }
        if (i_1 >= A.length || i_1 + 1 >= A.length) {
            return false;
        }

        if (A[i] + A[i_1] == A[i_2]) {
            return true;
        }

        return false;
    }
}
