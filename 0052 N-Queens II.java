class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        int[] board = new int[n];
        findSol(board, n, 0);
        return res;
    }

    public void findSol(int[] board, int n, int r) {
        if (r == n - 1) {
            for (int p = 0; p < n; p++) {
                boolean valid = true;
                for (int j = 0; j < r; j++) {
                    if (board[j] == p || (Math.abs(board[j] - p) == Math.abs(j - r))) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    res++;
                    return;
                }
            }
        } else {
            for (int p = 0; p < n; p++) {
                boolean valid = true;
                for (int j = 0; j < r; j++) {
                    if (board[j] == p || (Math.abs(board[j] - p) == Math.abs(j - r))) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    board[r] = p;
                    findSol(board, n, r + 1);
                }
            }
        }
    }    
}