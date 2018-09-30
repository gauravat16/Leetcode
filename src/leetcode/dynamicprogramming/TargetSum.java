/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;


/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        return findTargetSumWays(nums, S, 0, 0, 0);

    }


    public int findTargetSumWays(int[] nums, int targetSum, int currSum, int index, int count) {

        if (index >= nums.length) {
            if(currSum == targetSum){
                count++;
            }
            return count;
        }

        int currVal = nums[index];
        index++;
        int countPositive = findTargetSumWays(nums, targetSum, currSum + currVal, index, count);
        int countNegative = findTargetSumWays(nums, targetSum, currSum - currVal, index, count);

        return countPositive + countNegative;
    }


    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1, 0}, 1));
    }


}
