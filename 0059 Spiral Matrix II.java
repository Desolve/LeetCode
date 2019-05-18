class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] d = {0, 1};
        for (int i = 0, j = 0, cnt = 1; cnt <= n * n; cnt++) {
            res[i][j] = cnt;
            updateDir(res, d, i, j, n);              
            i += d[0];
            j += d[1];
        }
        return res;
    }
    public void updateDir(int[][] res, int[] d, int i, int j, int n) {
        int x = i + d[0], y = j + d[1];
        if (x < 0 || y < 0 || x >= n || y >= n || res[x][y] != 0) {
            if (d[0] == 0) {
                if (d[1] == 1) {
                    d[0] = 1; d[1] = 0;
                } else {
                    d[0] = -1; d[1] = 0; 
                }
            } else {
                if (d[0] == 1) {
                    d[0] = 0; d[1] = -1;
                } else {
                    d[0] = 0; d[1] = 1;
                }
            }
        }
    }
}