/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 */

public class CombinationSumIV {


    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }

        Map<Integer, Integer> dp = new HashMap<>();


        return helper(nums, target, dp);

    }


    public int helper(int[] nums, int target, Map<Integer, Integer> dp) {
        int count = 0;

        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }
        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        for (int num : nums) {
            count += helper(nums, target - num, dp);
        }

        dp.put(target, count);

        return count;
    }


    /**
     * Failed endeavour.
     *
     * @param nums
     * @param target
     * @param currentNum
     * @param index
     * @param count
     * @param numAlreadyTaken
     * @return
     */

    public int combinationSum4(int[] nums, int target, int currentNum, int index, int count, boolean numAlreadyTaken) {

        if (index >= nums.length || currentNum > target) {
            return count;
        }

        if (currentNum == target) {
            count++;
            return count;
        }
        int takeNoIncrement, takeButIncrement = 0, leaveIncrement;

        takeNoIncrement = combinationSum4(nums, target, currentNum + nums[index], index, count, true);

        if (!numAlreadyTaken) {
            takeButIncrement = combinationSum4(nums, target, currentNum + nums[index], index + 1, count, false);

        }

        leaveIncrement = combinationSum4(nums, target, currentNum, index + 1, count, false);

        return takeButIncrement + leaveIncrement + takeNoIncrement;


    }


    public static void main(String[] args) {

        System.out.println(new CombinationSumIV().combinationSum4(new int[]{4, 2, 1}, 32));

    }

}
