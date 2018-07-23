package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 */

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLIS = 1;

        for (int i = 0; i < nums.length; i++) {

            int maxVal = 0;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    maxVal = Math.max(maxVal, dp[j]);

                }
            }

            dp[i] = maxVal + 1;

            maxLIS = Math.max(dp[i], maxLIS);

        }

        return maxLIS;
    }


    /**
     * Brute force O(2^n)
     *
     * @param nums
     * @param currIndex
     * @param prevVal
     * @return
     */

    public int lengthOfLIS(int[] nums, int currIndex, int prevVal) {

        if (currIndex == nums.length) {
            return 0;
        }

        int lenIncluded = 0, lenExcluded = 0;

        if (prevVal < nums[currIndex]) {
            lenIncluded = 1 + lengthOfLIS(nums, currIndex + 1, nums[currIndex]);
        }

        lenExcluded = lengthOfLIS(nums, currIndex + 1, prevVal);

        return Math.max(lenExcluded, lenIncluded);

    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));


        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 10}));

    }
}
