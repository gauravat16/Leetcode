/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        Map<Integer, Integer> dp = new HashMap<>();

        dp.put(0, 1);

        return numTrees(n, dp);
    }

    //Iterative
    public int numTreesIterative(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }

        }

        return dp[n];
    }


    //Recursive
    public int numTrees(int n, Map<Integer, Integer> dp) {

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numTrees(i - 1, dp) * numTrees(n - i, dp);
        }

        dp.put(n, count);

        return count;


    }

    public static void main(String[] args) {

        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
        System.out.println(new UniqueBinarySearchTrees().numTreesIterative(3));
    }

}
