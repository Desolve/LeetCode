class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        for (int i = n - 2; i >= 0; --i) piles[i] += piles[i + 1];
        if (n <= 2) return piles[0];
        int[][] dp = new int[n][(n+1)/2 + 1];
        return helper(dp, piles, 0, 1);
    }
    private int helper(int[][] dp, int[] piles, int i, int M) {
        if (i == piles.length) return 0;
        if (2 * M >= piles.length - i) return piles[i];
        if (dp[i][M] != 0) return dp[i][M];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; ++x) {
            int nm = Math.max(M, x);
            min = Math.min(min, helper(dp, piles, i + x, nm));
        }
        dp[i][M] = piles[i] - min;
        return dp[i][M];
    }
}