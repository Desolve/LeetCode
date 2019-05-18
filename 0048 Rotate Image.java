class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) return;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len / 2; ++j) {
                swap(matrix, i, j, i, len - 1 - j);
            }
        }
    }
    public void swap(int[][] matrix, int i, int j, int a, int b) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = tmp;       
    }
}
/* slightly faster when not using function to swap
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) return;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 -j] = tmp;
            }
        }
    }
}
*/