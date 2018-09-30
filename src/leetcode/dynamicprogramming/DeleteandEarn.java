/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

/**
 * Given an array nums of integers, you can perform operations on the array.
 * <p>
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * <p>
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 */

public class DeleteandEarn {

    public int deleteAndEarn(int[] nums) {

        int[] sums = new int[10002];

        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]] += nums[i];
        }

        for (int i = 2; i < sums.length; i++) {
            sums[i] = Math.max(sums[i - 1], sums[i] + sums[i - 2]);

        }

        return sums[10001];

    }


    public static void main(String[] args) {
        System.out.println(new DeleteandEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
