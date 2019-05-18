class Solution {
    int row = 0;
    int col = 0;
    public boolean isToeplitzMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; ++i) {
            if(!checkDiagonal(i, 0, matrix)) return false;
        }
        for (int j = 0; j < col; ++j) {
            if(!checkDiagonal(0, j, matrix)) return false;
        }
        return true;
    }
    public boolean checkDiagonal(int r, int c, int[][] matrix) {
        int val = matrix[r][c];
        for (int i = r + 1, j = c + 1; i < row && j < col; ++i, ++j) {
            if (matrix[i][j] != val) return false;
        }
        return true;
    }
}