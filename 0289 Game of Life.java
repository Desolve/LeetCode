class Solution {
    private int m = 0, n = 0;
    private int[][] d = {{-1,1},{-1,0},{-1,-1},{0,1},{0,-1},{1,1},{1,0},{1,-1}};
    public void gameOfLife(int[][] board) {        
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                check(board, i, j);
            }
        }
        next(board);
    }
    public void check(int[][] board, int i, int j) {
        int cnt = 0;
        for (int k = 0; k < 8; ++k) {
            cnt += alive(board, i + d[k][0], j + d[k][1]);
        }
        if (board[i][j] % 2 == 1) {
            if (cnt == 2 || cnt == 3) board[i][j] += 2;
        } else if (cnt == 3) {
            board[i][j] += 2;
        }
    }
    public int alive(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        } else {
            return board[i][j] % 2;
        }
    }
    
    public void next(int[][] board) {
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] /= 2;
            }
        }
    }
    
    // public void printboard(int[][] board) {
    //     for (int i = 0; i < m; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             System.out.print(board[i][j] + " ");
    //         }
    //         System.out.println("");
    //     }
    // }
}