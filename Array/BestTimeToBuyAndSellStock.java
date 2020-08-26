class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0; i<prices.length-1; i++) {
            int profitPerDay = (prices[i + 1] - prices[i]);
            profit += Math.max(profitPerDay, 0);
        }
        return profit;
    }
}
