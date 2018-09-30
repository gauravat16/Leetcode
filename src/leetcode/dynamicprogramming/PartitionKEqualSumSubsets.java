/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 * <p>
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */

public class PartitionKEqualSumSubsets {


    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0) {
            return false;
        }

        sum /= k;

        boolean[] seen = new boolean[nums.length];

        return canPartitionKSubsets(nums, seen, k, 0, sum, 0);

    }


    public boolean canPartitionKSubsets(int[] nums, boolean[] seen, int k, int index, int subsetSum, int currSum) {

        if (k == 1) {
            return true;
        }

        if (currSum == subsetSum) {

            return canPartitionKSubsets(nums, seen, k - 1, 0, subsetSum, 0);
        }

        for (int i = index; i < nums.length; i++) {

            if (!seen[i]) {
                seen[i] = true;

                if (canPartitionKSubsets(nums, seen, k, i + 1, subsetSum, currSum + nums[i])) {
                    return true;

                }
                seen[i] = false;
            }
        }


        return false;


    }

    public static void main(String[] args) {

        System.out.println(new PartitionKEqualSumSubsets().canPartitionKSubsets(new int[]{1, 2, 3, 4}, 333));


    }
}
