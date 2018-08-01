package leetcode.dynamicprogramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {


        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0)
            return false;
        totalSum /= 2;


        Boolean[][] dp = new Boolean[nums.length + 1][totalSum + 1];


        return canPartition(nums, 0, totalSum, dp);

    }

    public boolean canPartition(int[] nums, int index, int targetSum, Boolean[][] dp) {

        if (index >= nums.length) {
            return targetSum == 0;
        }

        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }

        if (dp[index][targetSum] != null) {
            return dp[index][targetSum];
        }


        dp[index][targetSum] = canPartition(nums, index + 1, targetSum - nums[index], dp) ||
                canPartition(nums, index + 1, targetSum, dp);

        return dp[index][targetSum];

    }

    public static void main(String[] args) {

        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{11, 2, 3, 5}));

    }
}
