class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
        	// When in ascending order like a->b->c, c-a = (b-a) + (c-b), so we can calculate the profit by going through the whole array.
            if (prices[i+1] > prices[i]) profit += prices[i+1]-prices[i]; 
        }
        return profit;
    }
}