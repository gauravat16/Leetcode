/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
public class RangeSumQuery {

    private int[] nums;
    private int[] memo;

    public RangeSumQuery(int[] nums) {

        this.nums = nums;
        memo = new int[nums.length];

        Arrays.fill(memo, 0);
        buildMemo(nums);


    }

     void buildMemo(int[] nums) {
        if (nums.length==0){
            return;
        }
         memo[0] = nums[0];

         for (int i=1; i<nums.length;i++){
            memo[i] = memo[i-1]+nums[i];
        }

    }

    public int sumRange(int i, int j) {

        if (i == 0) {
            return memo[j];
        }


        return memo[j] - memo[i - 1];
    }

    public static void main(String[] args) {
        RangeSumQuery rangeSumQuery = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQuery.sumRange(0, 5));
        System.out.println(rangeSumQuery.sumRange(2, 5));
        System.out.println(rangeSumQuery.sumRange(0, 2));
    }
}
