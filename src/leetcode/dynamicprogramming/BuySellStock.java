package leetcode.dynamicprogramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 */


public class BuySellStock {

    public static int maxProfit(int[] prices) {

        if(prices.length==0){
            return 0;
        }


        int profit = Integer.MIN_VALUE, min = Integer.MAX_VALUE;


        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            if (profit < (prices[i] - min)) {
                profit = prices[i] - min;
            }


        }


        return profit;

    }

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{2, 4, 1}));

    }
}
