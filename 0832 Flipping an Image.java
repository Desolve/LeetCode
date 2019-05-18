class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) return A;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0, k = A[i].length-1; j < k; ++j, --k) {
                int tmp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = tmp;
            }
            for (int l = 0; l < A[i].length; ++l)
                A[i][l] ^= 1;
        }
        return A;
    }
}