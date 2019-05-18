// solution from tankztc, explained by cheriejw
class Solution {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res += grid[i][j] * 4 + 2; // 4 surfaces and top/bottom
                    res -= (i - 1 >= 0) ? Math.min(grid[i][j], grid[i-1][j]) * 2 : 0; // Minus i-axis connected area
                    res -= (j - 1 >= 0) ? Math.min(grid[i][j], grid[i][j-1]) * 2 : 0; // Minus j-axis connected area
                }
            }
        }
        return res;
    }
}