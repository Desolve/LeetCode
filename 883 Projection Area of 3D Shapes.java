class Solution {
    public int projectionArea(int[][] grid) {
        int xy = 0, xz = 0, yz = 0;        
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 0) ++xy;
                if (grid[i][j] > row[i]) row[i] = grid[i][j];
                if (grid[i][j] > col[j]) col[j] = grid[i][j];                
            }
        }
        for (int i = 0; i < grid.length; ++i) xz += row[i];
        for (int j = 0; j < grid[0].length; ++j) yz += col[j];
        return xy + xz + yz;
    }
}