package leetcode.dynamicprogramming;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 */

public class CountNumberswithUniqueDigits {


    public int countNumbersWithUniqueDigits(int n) {


        int[] dp = new int[n + 1];
        dp[0] = 1;

        int k = 9, sum = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = dp[i - 1] * 9;
            else
                dp[i] = dp[i - 1] * k--;

            sum += dp[i];

        }

        return sum;

    }

    public static void main(String[] args) {

        System.out.println(new CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(2));

    }
}
