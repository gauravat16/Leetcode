package leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {

    private int rob(int[] num, int lo, int hi) {
        int includeHouse = 0, excludeHouse = 0;

        for (int j = lo; j <= hi; j++) {
            int i = includeHouse;
            int e = excludeHouse;

            includeHouse = excludeHouse + num[j];
            excludeHouse = Math.max(i, e);
        }
        return Math.max(includeHouse, excludeHouse);
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }


    /**
     * Doesnt work
     *
     * @param args
     */
//    public int rob(int[] nums) {
//
//
//        if(nums.length==0){
//            return 0;
//        }
//        if(nums.length==1){
//            return nums[0];
//        }
//
//        if(nums.length==2){
//            return Math.max(nums[0], nums[1]);
//        }
//
//        if(nums.length==3){
//            return Math.max(nums[2], Math.max(nums[0], nums[1]));
//
//        }
//        Set<Integer> outOfBoundsSet = new HashSet<>();
//        outOfBoundsSet.add(nums.length - 1);
//        int loot0 = 0;
//        loot0  = rob(nums, outOfBoundsSet, 0, 0);
//
//        outOfBoundsSet.clear();
//        outOfBoundsSet.add(0);
//
//        int loot1 = rob(nums, outOfBoundsSet, 0, 1);
//
//        return Math.max(loot0, loot1);
//
//    }
//
//    public int rob(int[] nums, Set<Integer> outOfBoundsSet, int loot, int index) {
//
//        if (index >= nums.length) {
//            return loot;
//        }
//        int taken = 0, left = 0;
//        if (!outOfBoundsSet.contains(index)) {
//
//
//            handleSet(index, nums, outOfBoundsSet, true);
//            taken = rob(nums, outOfBoundsSet, loot + nums[index], index + 1);
//
//
//        } else {
//
//
//            left = rob(nums, outOfBoundsSet, loot, index + 1);
//
//        }
//
//
//        return Math.max(taken, left);
//
//
//    }
//
//
//    void handleSet(int index, int[] nums, Set<Integer> outOfBoundsSet, boolean isAdded) {
//        int backIndex = -1, fwdIndex = -1;
//        if (index == 0) {
//            backIndex = nums.length - 1;
//
//        } else {
//            backIndex = index - 1;
//
//
//        }
//
//        if (index == nums.length - 1) {
//            fwdIndex = 0;
//
//        } else {
//            fwdIndex = index + 1;
//
//        }
//
//        if (isAdded) {
//            outOfBoundsSet.add(backIndex);
//
//            if (fwdIndex != nums.length - 1) {
//                outOfBoundsSet.add(fwdIndex);
//
//            } else {
//                if (!outOfBoundsSet.contains(0)) {
//                    outOfBoundsSet.add(fwdIndex);
//
//                }
//            }
//
//        } else {
//            outOfBoundsSet.remove(backIndex);
//            outOfBoundsSet.remove(fwdIndex);
//        }
//
//    }
    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2, 1, 1, 2}));
        System.out.println(new HouseRobberII().rob(new int[]{2, 3, 2}));
        System.out.println(new HouseRobberII().rob(new int[]{1, 3, 1, 3, 100}));
    }
}
