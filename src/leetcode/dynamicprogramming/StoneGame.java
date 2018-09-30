/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.*;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 */

public class StoneGame {


    public boolean stoneGame(int[] piles) {

        int sum = Arrays.stream(piles).sum();

        Integer[][] memo = new Integer[piles.length][piles.length];

        int byAlex = helper(piles, piles.length / 2, 0, piles.length - 1, memo);


        return byAlex > sum / 2;


    }

    private int helper(int[] piles, int triesRemaining, int index1, int index2, Integer[][] memo) {

        if (triesRemaining == 0) {
            return 0;
        }

        if (index1 >= piles.length || index2 <= 0) {
            return 0;
        }

        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }


        int maxByAlex1 = 0;
        int maxByAlex2 = 0;


        maxByAlex1 = piles[index1] + helper(piles, triesRemaining - 1, index1 + 1, index2, memo);


        maxByAlex2 = piles[index2] + helper(piles, triesRemaining - 1, index1, index2 - 1, memo);


        memo[index1][index2] = Math.max(maxByAlex1, maxByAlex2);

        return memo[index1][index2];

    }


    public static void main(String[] args) {

        System.out.println(new StoneGame().stoneGame(new int[]{3, 7, 88, 3}));

    }


}
