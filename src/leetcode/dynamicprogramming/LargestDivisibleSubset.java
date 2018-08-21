package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 */

public class LargestDivisibleSubset {

    public static void main(String[] args) {

        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{4,8,10,240}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,3}));

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> returnList = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return returnList;
        }

        Arrays.sort(nums);

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }

        int maxValIndex = 0, currMaxLen = 0;

        for (int i = 0; i < dp.length; i++) {
            maxValIndex = (dp[maxValIndex] < dp[i]) ? i : maxValIndex;
        }

        currMaxLen = dp[maxValIndex];

        for (int i = maxValIndex; i >= 0; i--) {
            if (nums[maxValIndex] % nums[i] == 0 && dp[i] == currMaxLen) {
                currMaxLen--;
                returnList.add(nums[i]);
                maxValIndex = i;
            }
        }

        return returnList;
    }


}
