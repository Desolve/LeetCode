class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
           m row, n column
           matrix[i][j] = index (i * n + j)
           index mid => i = mid / n, j = mid % n
        */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, up = m * n -1;
        while (lo <= up) {
            int mid = lo + (up - lo) / 2;
            int i = mid / n, j = mid % n;
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) lo = mid + 1;
            else up = mid - 1;
        }
        return false;
    }
}