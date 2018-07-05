package leetcode.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

public class BuySellStockFee {

    public int maxProfitSwitcher(int[] prices, int fee, boolean isRecursive) {


        if (isRecursive) {
            Map<Integer, Integer> dp = new HashMap<>();
            return maxProfit(prices, fee, 0, 0, false, dp);
        } else
            return maxProfit(prices, fee);

    }


    /**
     * Non Memoized Recursive - TLE
     *
     * @param prices
     * @param fee
     * @param index
     * @param profit
     * @param hasStock
     * @return
     */

    public int maxProfit(int[] prices, int fee, int index, int profit, boolean hasStock, Map<Integer, Integer> dp) {

//        if (dp.containsKey(index)) {
//            return dp.get(index);
//        }
        if (index >= prices.length) {
            return profit;
        }


        int profitIfSold = 0;
        int profitIfBought = 0;


        if (!hasStock)
            profitIfBought = maxProfit(prices, fee, index + 1, profit - prices[index], true, dp);
        if (hasStock)
            profitIfSold = maxProfit(prices, fee, index + 1, profit + prices[index] - fee, false, dp);
        int profitIfLeft = maxProfit(prices, fee, index + 1, profit, hasStock, dp);

        dp.put(index, Math.max(Math.max(profitIfBought, profitIfSold), profitIfLeft));

        return dp.get(index);


    }


    public int maxProfit(int[] prices, int fee) {

        long sellingPrice = 0, buyingPrice = Integer.MIN_VALUE;

        for (int price : prices) {

            long sellingPriceOld;
            sellingPriceOld = sellingPrice;

            sellingPrice = Math.max(sellingPrice, buyingPrice + price - fee);
            buyingPrice = Math.max(buyingPrice, sellingPriceOld - price);
        }

        return (int) sellingPrice;


    }


    public static void main(String[] args) {
        System.out.println(new BuySellStockFee().maxProfitSwitcher(new int[]{1,2,3,0,2}, 0, true));
        System.out.println(new BuySellStockFee().maxProfitSwitcher(new int[]{1, 3, 2, 8, 4, 9}, 2, false));
    }


}
