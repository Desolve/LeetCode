class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < row; ++j) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}