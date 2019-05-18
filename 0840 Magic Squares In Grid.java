class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;
        for (int i = 1; i < row - 1; i++)
            for (int j = 1; j < col - 1; j++)
                if (grid[i][j] == 5 && check(i, j, grid)) ++cnt;
        return cnt;
    }
    public boolean check(int i, int j, int[][] grid) {
        return grid[i-1][j-1] >= 1 && grid[i-1][j-1] <= 9 && grid[i-1][j] >= 1 && grid[i-1][j] <= 9 && grid[i-1][j+1] >= 1 && grid[i-1][j+1] <= 9 && 
            grid[i][j-1] >= 1 && grid[i][j-1] <= 9 && grid[i][j+1] >= 1 && grid[i][j+1] <= 9 && 
            grid[i+1][j-1] >= 1 && grid[i+1][j-1] <= 9 && grid[i+1][j] >= 1 && grid[i+1][j] <= 9 && grid[i+1][j+1] >= 1 && grid[i+1][j+1] <= 9 && 
            grid[i][j-1] + grid[i][j+1] == 10 && grid[i-1][j] + grid[i+1][j] == 10 && 
            grid[i-1][j-1] + grid[i+1][j+1] == 10 && grid[i-1][j+1] + grid[i+1][j-1] == 10 && 
            grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] == 15 && grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1] == 15 &&
            grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] == 15 && grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1] == 15;
    }
}

/* More clear solution from xmenmagneto
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                if (passCheck(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean passCheck(int x, int y, int[][] grid) {
        int target = Integer.MIN_VALUE;
        // check rows;
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[x + i][y + j] > 9 || grid[x + i][y + j] < 1) {
                    return false;
                }
                rowSum += grid[x + i][y + j];
            }
            if (target == Integer.MIN_VALUE) {
                target = rowSum;
            } else if (target != rowSum) {
                return false;
            }
        }

        // check cols:
        for (int j = 0; j < 3; j++) {
            int colSum = 0;
            for (int i = 0; i < 3; i++) {
                if (grid[x + i][y + j] > 9 || grid[x + i][y + j] < 1) {
                    return false;
                }
                colSum += grid[x + i][y + j];
            }
            if (target != colSum) {
                return false;
            }
        }
        // check diagonal
        int diagonalSum = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        if (diagonalSum != target) {
            return false;
        }

        // check anti diagonal
        int antiDiagonalSum = grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2];
        if (target != antiDiagonalSum) {
            return false;
        }
        return true;
    }
}

*/