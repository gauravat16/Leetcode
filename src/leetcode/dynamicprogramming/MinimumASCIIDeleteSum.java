package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 */

public class MinimumASCIIDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1Len; i++) {

            for (int j = 0; j <= s2Len; j++) {

                if (i == 0 || j == 0) {
                    int a = 0;
                    for (int k = 1; k <= Math.max(i, j); k++) {
                        a += (i == 0) ? s2.charAt(k - 1) : s1.charAt(k - 1);
                    }

                    memo[i][j] = a;
                } else if (s1.codePointAt(i - 1) == s2.codePointAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {

                    memo[i][j] = Math.min(s1.codePointAt(i - 1) + memo[i - 1][j], s2.codePointAt(j - 1) + memo[i][j - 1]);
                }
            }

        }

        return memo[s1Len][s2Len];


    }


//    public int minimumDeleteSum(char[] s1Array, char[] s2Array, int index1, int index2, int sum) {
//
//        if (index1 >= s1Array.length || index2 >= s2Array.length) {
//
//
//            return sum;
//        }
//
//
//
//        if (s1Array[index1] == s2Array[index2]) {
//            index1++;
//            index2++;
//        }
//
//        int sumDelFromS1 = Integer.MAX_VALUE, sumDelFromS2 = Integer.MAX_VALUE, sumDelFromBoth = Integer.MAX_VALUE;
//
//        if (index1 < s1Array.length)
//            sumDelFromS1 = minimumDeleteSum(s1Array, s2Array, index1 + 1, index2, sum + s1Array[index1]);
//
//        if (index2 < s2Array.length)
//            sumDelFromS2 = minimumDeleteSum(s1Array, s2Array, index1, index2 + 1, sum + s2Array[index2]);
//
////        if (index2 < s2Array.length && index1 < s1Array.length)
////            sumDelFromBoth = minimumDeleteSum(s1Array, s2Array, index1 + 1, index2 + 1, sum + s2Array[index2] + s1Array[index1]);
//
//        sum = Math.min(sumDelFromS1, sumDelFromS2);
//
//
//        return sum;
//
//    }


    public static void main(String[] args) {
        MinimumASCIIDeleteSum minimumASCIIDeleteSum = new MinimumASCIIDeleteSum();

        System.out.println(minimumASCIIDeleteSum.minimumDeleteSum("sea", "eat"));
    }
}
