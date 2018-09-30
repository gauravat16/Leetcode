/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 * <p>
 * Examples:
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 */

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }


        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }


        }


        return 1 + Math.max(up[nums.length - 1], down[nums.length - 1]);

    }


    public int wiggleMaxLengthGreedy(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int count = 0;

        int preDiff = nums[1] - nums[0];

        count = (preDiff != 0) ? 2 : 1;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                count++;
                preDiff = diff;
            }
        }


        return count;


    }


    public static void main(String[] args) {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(new WiggleSubsequence().wiggleMaxLengthGreedy(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }
}
