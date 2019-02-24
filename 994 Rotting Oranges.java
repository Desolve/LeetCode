class Solution {
    public int orangesRotting(int[][] grid) {
        boolean rotted = true;
        boolean fresh = false;        
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] rotting;
        while (rotted) {
            rotted = false;
            fresh = false;
            rotting = new boolean[m][n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        if ((i-1 >= 0 && grid[i-1][j] == 2 && !rotting[i-1][j]) ||
                            (i+1 < m  && grid[i+1][j] == 2 && !rotting[i+1][j]) ||
                            (j-1 >= 0 && grid[i][j-1] == 2 && !rotting[i][j-1]) ||
                            (j+1 < n  && grid[i][j+1] == 2 && !rotting[i][j+1])) {
                            grid[i][j] = 2;
                            rotting[i][j] = true;
                            rotted = true;
                        } else {
                            fresh = true;
                        }
                    } else if (grid[i][j] == 2 && !rotting[i][j]) {
                        if (i-1 >= 0 && grid[i-1][j] == 1) {
                            grid[i-1][j] = 2;
                            rotting[i-1][j] = true;
                            rotted = true;
                        }
                        if (i+1 < m  && grid[i+1][j] == 1) {
                            grid[i+1][j] = 2;
                            rotting[i+1][j] = true;
                            rotted = true;
                        }
                        if (j-1 >= 0 && grid[i][j-1] == 1) {
                            grid[i][j-1] = 2;
                            rotting[i][j-1] = true;
                            rotted = true;
                        } 
                        if (j+1 < n  && grid[i][j+1] == 1) {
                            grid[i][j+1] = 2;
                            rotting[i][j+1] = true;
                            rotted = true;
                        }
                    }
                }
            }
            if (rotted) ++time;
        }
        if (fresh) return -1;
        return time;
    }
}