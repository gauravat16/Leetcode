/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;


import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 */


public class MaxRobbery {

    public static int rob(int[] nums) {

        int[] memo = new int[nums.length];

        Arrays.fill(memo, -1);

        return rob(nums, memo, 0);
    }

    public static int rob(int[] nums, int[] memo, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }


        memo[index] = Math.max(nums[index] + rob(nums, memo, index + 2), rob(nums, memo, index + 1));

        return memo[index];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
