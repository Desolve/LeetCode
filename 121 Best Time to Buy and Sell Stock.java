class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0, min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i]; // Change the minimum
            } else {
                if(prices[i] - min > profit) {
                    profit = prices[i] - min; // Check the profit
                }
                    
            }
        }
        return profit;
    }
}