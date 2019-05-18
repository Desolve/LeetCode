class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit, i = 0, 0
        while i < len(prices):
            # Find next local minimum
            while i < len(prices)-1 and prices[i+1] <= prices[i]: i += 1
            lmin, i = prices[i], i+1
            # Find next local maximum
            while i < len(prices)-1 and prices[i+1] >= prices[i]: i += 1
            profit += prices[i] - lmin if i < len(prices) else 0
            i += 1
        return profit

''' 
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(len(prices)-1):
            if prices[i+1] > prices[i]:
                profit += prices[i+1] - prices[i]
        return profit
'''