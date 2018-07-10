package leetcode.dynamicprogramming;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 */

public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];

        int max = -1;

        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= B.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                max = Math.max(max, dp[i][j]);

            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthofRepeatedSubarray().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
