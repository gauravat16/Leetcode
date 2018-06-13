package leetcode.dynamicprogramming;


public class BuySellStockFee {

    public int maxProfitSwitcher(int[] prices, int fee, boolean isRecursive) {


        if (isRecursive)
            return maxProfit(prices, fee, 0, 0, false);
        else
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

    public int maxProfit(int[] prices, int fee, int index, int profit, boolean hasStock) {

        if (index >= prices.length) {
            return profit;
        }


        int profitIfSold = 0;
        int profitIfBought = 0;


        if (!hasStock)
            profitIfBought = maxProfit(prices, fee, index + 1, profit - prices[index], true);
        if (hasStock)
            profitIfSold = maxProfit(prices, fee, index + 1, profit + prices[index] - fee, false);
        int profitIfLeft = maxProfit(prices, fee, index + 1, profit, hasStock);

        return Math.max(Math.max(profitIfBought, profitIfSold), profitIfLeft);


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
        System.out.println(new BuySellStockFee().maxProfitSwitcher(new int[]{1, 3, 2, 8, 4, 9}, 2, true));
        System.out.println(new BuySellStockFee().maxProfitSwitcher(new int[]{1, 3, 2, 8, 4, 9}, 2, false));
    }


}
