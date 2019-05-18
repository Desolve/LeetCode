class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!checkSquare(board, i, j)) return false;
            }
        }
        for (int i = 0; i < 9; ++i) {
            if (!checkRow(board, i)) return false;
        }
        for (int j = 0; j < 9; ++j) {
            if (!checkCol(board, j)) return false;
        }
        return true;
    }
    public boolean checkSquare(char[][] board, int i, int j) {
        boolean[] check = new boolean[9];
        for (int r = i * 3; r < i * 3 + 3; ++r) {
            for (int c = j * 3; c < j * 3 + 3; ++c) {
                char ch = board[r][c];
                if (board[r][c] != '.') {
                    if (!check[ch - '1'])
                        check[ch - '1'] = true;
                    else 
                        return false;
                }
            }
        }
        return true;
    }
    public boolean checkRow(char[][] board, int i) {
        boolean[] check = new boolean[9];
        for (int j = 0; j < 9; ++j) {
            char ch = board[i][j];
            if (board[i][j] != '.') {
                if (!check[ch - '1'])
                    check[ch - '1'] = true;
                else 
                    return false;
            }
        }
        return true;
    }
    public boolean checkCol(char[][] board, int j) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; ++i) {
            char ch = board[i][j];
            if (board[i][j] != '.') {
                if (!check[ch - '1'])
                    check[ch - '1'] = true;
                else 
                    return false;
            }
        }
        return true;
    }
}