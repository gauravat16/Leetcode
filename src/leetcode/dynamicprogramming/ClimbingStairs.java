package leetcode.dynamicprogramming;

import java.util.HashMap;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */

public class ClimbingStairs {

    public static int climbStairs(int n) {
        return climbStairs(n, 0, new HashMap<>());
    }


    public static int climbStairs(int n, int ways, HashMap<Integer, Integer> wayMap) {

        if (wayMap.containsKey(n)) {
            return wayMap.get(n);
        }


        if (n < 0) {
            return ways;
        }
        if (n == 0) {
            ways++;
            return ways;
        }

        int forOne = climbStairs(n - 1, ways, wayMap);
        wayMap.put(n - 1, forOne);


        int forTwo = climbStairs(n - 2, ways, wayMap);

        wayMap.put(n - 2, forTwo);


        return forOne + forTwo;


    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }


}
