package leetcode.dynamicprogramming;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum
 * cost to reach the top of the floor, and you can either start from the step with index 0,
 * or the step with index 1.
 */

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost, new int[cost.length], 0), minCostClimbingStairs(cost, new int[cost.length], 1));
    }


    public int minCostClimbingStairs(int[] costs, int[] memo, int index) {


        if (index >= costs.length) {
            return 0;
        }

        if (memo[index] > 0) {
            return memo[index];
        }


        memo[index] = costs[index] + Math.min(minCostClimbingStairs(costs, memo, index + 2), minCostClimbingStairs(costs, memo, index + 1));
        return memo[index];


    }


    public static void main(String[] args) {

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));


    }
}
