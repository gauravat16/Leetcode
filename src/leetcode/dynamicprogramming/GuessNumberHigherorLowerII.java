/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherorLowerII {


    public int getMoneyAmount(int n) {

        int[][] dp = new int[n + 1][n + 1];

        return getMoneyAmount(n, 1, dp);

    }

    public int getMoneyAmount(int n, int currentIndex, int[][] dp) {

        if (currentIndex >= n) {
            return 0;
        }


        if (dp[n][currentIndex] != 0) {
            return dp[n][currentIndex];
        }

        int minTillNow = Integer.MAX_VALUE;

        for (int i = currentIndex; i <= n; i++) {
            int tempSum = i + Math.max(getMoneyAmount(i - 1, currentIndex, dp), getMoneyAmount(n, i + 1, dp));
            minTillNow = Math.min(minTillNow, tempSum);
        }

        dp[n][currentIndex] = minTillNow;

        return dp[n][currentIndex];


    }


    public static void main(String[] args) {

        System.out.println(new GuessNumberHigherorLowerII().getMoneyAmount(10));

    }
}
