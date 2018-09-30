/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 */

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int dp[][] = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int windowSize = 2; windowSize <= s.length(); windowSize++) {
            for (int start = 0; start <= s.length() - windowSize; start++) {

                int end = windowSize + start - 1;

                if (s.codePointAt(start) == s.codePointAt(end)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }

            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }
}
