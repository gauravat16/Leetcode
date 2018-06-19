package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
 * <p>
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 */

public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {

        int[][] memo = new int[nums.length + 1][nums.length + 1];

        int player1MaxProfit = PredictTheWinner(nums, 0, nums.length - 1, memo);

        int sum = Arrays.stream(nums).sum();

        return player1MaxProfit >= (sum - player1MaxProfit);


    }

    private int PredictTheWinner(int[] nums, int start, int end, int[][] memo) {

        if (start > end) {
            return 0;
        }
        int chooseStart, chooseEnd;
        if (memo[start][end] == 0) {
            chooseStart = nums[start] + Math.min(PredictTheWinner(nums, start + 1, end - 1, memo),
                                                 PredictTheWinner(nums, start + 2, end, memo));
            chooseEnd = nums[end] + Math.min(PredictTheWinner(nums, start, end - 2, memo),
                                             PredictTheWinner(nums, start + 1, end - 1, memo));

            memo[start][end] = Math.max(chooseEnd, chooseStart);


        }



        return memo[start][end];
    }


    public static void main(String[] args) {

        System.out.println(new PredicttheWinner().PredictTheWinner(new int[]{1, 5, 233, 7}));

    }


}
