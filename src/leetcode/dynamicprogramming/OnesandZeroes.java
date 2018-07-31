package leetcode.dynamicprogramming;

import java.util.Arrays;

public class OnesandZeroes {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[m + 1][n + 1][strs.length];

        return findMaxForm(strs, m, n, 0, dp);
    }


    public int findMaxForm(String[] strs, int m, int n, int index, int[][][] dp) {

        if (index >= strs.length) {
            return 0;
        }

        if (m <= 0 && n <= 0) {
            return 0;
        }

        if (dp[m][n][index] > 0) {
            return dp[m][n][index];
        }

        int[] ret = canBeGenerated(strs[index], m, n);
        int takenCount = 0, leftCount;
        if (ret[0] == 1) {
            takenCount = 1 + findMaxForm(strs, ret[1], ret[2], index + 1, dp);
        }
        leftCount = findMaxForm(strs, m, n, index + 1, dp);

        dp[m][n][index] = Math.max(takenCount, leftCount);

        return dp[m][n][index];

    }

    public int[] canBeGenerated(String s, int m, int n) {
        boolean stringProcessed = true;
        int[] ret = new int[3];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (m <= 0) {
                    stringProcessed = false;
                    break;
                }
                m--;
            }
            if (c == '1') {

                if (n <= 0) {
                    stringProcessed = false;

                    break;
                }
                n--;
            }
        }

        if (stringProcessed) {
            ret[0] = 1;
        } else {
            ret[0] = 0;

        }

        ret[1] = m;
        ret[2] = n;

        return ret;
    }


    public static void main(String[] args) {

//        System.out.println(new OnesandZeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(new OnesandZeroes().findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3));


    }
}
