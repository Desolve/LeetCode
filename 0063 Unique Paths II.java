class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length;
        int n = obs[0].length;
        if (obs == null || obs[0][0] == 1) return 0;
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obs[i][j] != 1) {
                    if (i - 1 >= 0) res[i][j] += res[i - 1][j];
                    if (j - 1 >= 0) res[i][j] += res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}