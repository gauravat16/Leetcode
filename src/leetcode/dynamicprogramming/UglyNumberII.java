/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

public class UglyNumberII {

    /**
     * DP
     *
     * @param n
     * @return
     */

    public int nthUglyNumber(int n) {
        int[] uglyArr = new int[n];

        int next_2_multiple = 2;
        int next_3_multiple = 3;
        int next_5_multiple = 5;

        int i2 = 0, i3 = 0, i5 = 0;

        int next_ugly_num = 1;

        uglyArr[0] = next_ugly_num;

        for (int i = 1; i < n; i++) {
            next_ugly_num = Math.min(next_2_multiple, Math.min(next_3_multiple, next_5_multiple));
            uglyArr[i] = next_ugly_num;

            if (next_ugly_num == next_2_multiple) {
                next_2_multiple = uglyArr[++i2] * 2;
            }
            if (next_ugly_num == next_3_multiple) {
                next_3_multiple = uglyArr[++i3] * 3;
            }
            if (next_ugly_num == next_5_multiple) {
                next_5_multiple = uglyArr[++i5] * 5;
            }
        }

        return next_ugly_num;

    }

    /**
     * This code is TLE
     *
     * @param args
     */
//    public int nthUglyNumber(int n) {
//
//        int uglynum = 1;
//        int count = 1;
//
//        int i = 2;
//        while (count < n) {
//            if (isUgly(i)) {
//                count++;
//                uglynum = i;
//            }
//            i++;
//
//        }
//
//        return uglynum;
//
//    }
//
//    private boolean isUgly(int n) {
//
//        n = getDivided(n, 2);
//        n = getDivided(n, 3);
//        n = getDivided(n, 5);
//
//        return n == 1;
//    }
//
//    private int getDivided(int n, int m) {
//        while (n % m == 0) {
//            n = n / m;
//        }
//        return n;
//    }
    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }
}
