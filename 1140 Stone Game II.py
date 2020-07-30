class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        for i in range(n - 2, -1, -1):
            piles[i] += piles[i + 1]
        if n <= 2:
            return piles[0]
        dp = [[0 for i in range((n+1)//2 + 1)] for j in range(n)]
        return self.helper(dp, piles, 0, 1)
    
    def helper(self, dp: List[List[int]], piles: List[int], i: int, M: int) -> int:
        if i == len(piles): return 0
        if 2 * M >= len(piles) - i: return piles[i]
        if dp[i][M] != 0: return dp[i][M]
        dp[i][M] = piles[i] - min(self.helper(dp, piles, i + x, max(M, x)) for x in range(1, 2 * M+1))
        return dp[i][M]
