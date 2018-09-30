/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] memo = new int[triangle.size()][triangle.size()];

        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }

        return minimumTotal(triangle, 0, 0, memo);
    }


    public int minimumTotal(List<List<Integer>> triangle, int indexList, int indexPrev, int[][] memo) {

        if (indexList >= triangle.size()) {
            return 0;
        }

        if (indexPrev >= triangle.get(indexList).size()) {
            return 0;
        }
        if (memo[indexList][indexPrev] != Integer.MIN_VALUE) {
            return memo[indexList][indexPrev];
        }


        int ithtaken = minimumTotal(triangle, indexList + 1, indexPrev, memo);
        int iPlus1taken = minimumTotal(triangle, indexList + 1, indexPrev + 1, memo);


        memo[indexList][indexPrev] = Math.min(ithtaken, iPlus1taken) + triangle.get(indexList).get(indexPrev);

        return memo[indexList][indexPrev];


    }


    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers_1 = new ArrayList<>();
        List<Integer> integers_2 = new ArrayList<>();
        List<Integer> integers_3 = new ArrayList<>();
        List<Integer> integers_4 = new ArrayList<>();

//        integers_1.add(2);
//        lists.add(integers_1);
//
//        integers_2.add(3);
//        integers_2.add(4);
//        lists.add(integers_2);
//
//        integers_3.add(6);
//        integers_3.add(5);
//        integers_3.add(7);
//        lists.add(integers_3);
//
//        integers_4.add(4);
//        integers_4.add(1);
//        integers_4.add(8);
//        integers_4.add(3);
//        lists.add(integers_4);
//
        integers_1.add(-1);
        lists.add(integers_1);

        integers_2.add(2);
        integers_2.add(3);
        lists.add(integers_2);

        integers_3.add(1);
        integers_3.add(-1);
        integers_3.add(-3);
        lists.add(integers_3);


        System.out.println(new Triangle().minimumTotal(lists));
    }
}
