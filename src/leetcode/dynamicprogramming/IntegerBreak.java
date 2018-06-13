package leetcode.dynamicprogramming;


/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */

public class IntegerBreak {


    public int integerBreak(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;


        for (int i = 2; i <= n; i++) {

            int max = 1;

            for (int j = 1; j < i; j++) {
                int fac1 = Math.max(j, dp[j]);
                int fac2 = Math.max(i - j, dp[i - j]);

                max = Math.max(max, fac1 * fac2);

            }

            dp[i] = max;


        }

        return dp[n];
    }


    public static void main(String[] args) {

        System.out.println(new IntegerBreak().integerBreak(10));

    }

}
