class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0
        res, low = 0, prices[0]
        for i in range(1, len(prices)):
            if prices[i] < low:
                low = prices[i]
            else:
                res = max(res, prices[i] - low)
        return res