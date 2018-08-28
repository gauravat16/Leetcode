package leetcode.dynamicprogramming;

import java.util.Arrays;

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

        int[][] dp = new int[len][len];

        Arrays.fill(dp[0], 1);

        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int lastIndex = i;
            for (int j = i + 1; j < len; j++) {


                if (isFactorial(A, lastIndex -1, lastIndex,j)) {
                    int temp = dp[i][lastIndex];
                    dp[i][j] = temp + 2;
                    lastIndex = j + 1;
                    if(lastIndex < len){
                        dp[i][lastIndex] = dp[i][j];

                    }

                } else {
                    dp[i][j] = dp[i][lastIndex];

                }


            }
            maxLen = Math.max(dp[i][len - 1], maxLen);

        }

        return maxLen;


    }

    boolean isFactorial(int[] A, int i, int i_1, int i_2) {
        if(i < 0){
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
