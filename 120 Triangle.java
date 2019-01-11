class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        if (n == 1) return dp[0];
        
        for (int i = 1; i < n; ++i) {
            List<Integer> row = triangle.get(i);            
            dp[i] = dp[i-1] + row.get(i);
            for (int j = i - 1; j >= 1; --j) {
                dp[j] = Math.min(dp[j], dp[j-1]) + row.get(j);
            }
            dp[0] = dp[0] + row.get(0);
        }
        int res = dp[0];
        for (int k = 1; k < n; ++k) {
            res = Math.min(res, dp[k]);
        }
        return res;
    }
}