/*
 * Copyright (c) 2019.  Gaurav Sharma, All rights reserved.
 */

package leetcode.practice.trees;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length - 1, false, null);


    }

    public TreeNode helper(int[] nums, int start, int end, boolean isLeft, TreeNode node) {

        if (start > end) {
            return node;
        }


        int maxIndex = getMaxIndex(nums, start, end);

        if (node == null) {
            node = new TreeNode(nums[maxIndex]);
        } else {
            if (isLeft) {
                node.left = new TreeNode(nums[maxIndex]);
                node = node.left;
            } else {
                node.right = new TreeNode(nums[maxIndex]);
                node = node.right;

            }
        }

        helper(nums, start, maxIndex - 1, true, node);
        helper(nums, maxIndex + 1, end, false, node);

        return node;


    }

    public int getMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {

        int[] inp = new int[]{3, 2, 1, 6, 0, 5};
        new MaximumBinaryTree().constructMaximumBinaryTree(inp);
    }
}
