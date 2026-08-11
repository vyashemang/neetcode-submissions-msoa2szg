class Solution {
    public int maxProfit(int[] prices) {
        int minStock = Integer.MAX_VALUE;
        int maxProfit = -1;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minStock) {
                minStock = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minStock);
        }

        return maxProfit;
    }
}
