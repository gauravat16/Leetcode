package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class BuySellStockCoolDown {


    public int maxProfitSwitcher(int[] prices, boolean isRecursive) {


        if (isRecursive) {
            Map<Integer, Integer> dp = new HashMap<>();
            Map<Integer, Integer> sell = new HashMap<>();

            return maxProfit(prices, 0, false, dp, sell);
        }

        return 0;

    }

    public int maxProfit(int[] prices) {

        Map<Integer, Integer> dp = new HashMap<>();
        Map<Integer, Integer> sell = new HashMap<>();
        return maxProfit(prices, 0, false, dp, sell);

    }


    public int maxProfit(int[] prices, int index, boolean hasStock, Map<Integer, Integer> buy, Map<Integer, Integer> sell) {

        if (index >= prices.length) {
            return 0;
        }


        int profitIfSold = 0;
        int profitIfBought = 0;


        if (!hasStock) {
            if (buy.containsKey(index)) {
                return buy.get(index);
            } else {
                profitIfBought = Math.max(maxProfit(prices, index + 1, true, buy, sell) - prices[index],
                        maxProfit(prices, index + 1, false, buy, sell));
                buy.put(index, profitIfBought);

                return profitIfBought;


            }
        } else {

            if (sell.containsKey(index)) {
                return sell.get(index);
            } else {
                profitIfSold = Math.max(prices[index] + maxProfit(prices, index + 2, false, buy, sell),
                        maxProfit(prices, index + 1, true, buy, sell));
                sell.put(index, profitIfSold);
                return profitIfSold;
            }
        }


    }


    public static void main(String[] args) {
        System.out.println(new BuySellStockCoolDown().maxProfitSwitcher(new int[]{1, 2, 4}, true));
    }

}
