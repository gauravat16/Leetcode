package leetcode.dynamicprogramming;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int maxTillNow = 0;
        int minNegativeVal = Integer.MIN_VALUE;
        boolean allNegative = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                allNegative = false;
            } else {
                minNegativeVal = Math.max(minNegativeVal, nums[i]);
            }
            maxTillNow = Math.max(nums[i], nums[i] + maxTillNow);
            maxSoFar = Math.max(maxSoFar, maxTillNow);
        }

        return (allNegative) ? minNegativeVal : maxSoFar;
    }

    public static int maxSubArray(int[] nums, int index, int sum) {

        if (index >= nums.length) {
            return sum;
        }

        return Math.max(maxSubArray(nums, index + 1, sum + nums[index]), maxSubArray(nums, index + 1, 0));
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1}));
    }
}
