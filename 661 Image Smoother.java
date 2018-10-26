class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int rows = M.length;
        if (rows == 0) return new int[0][];
        int cols = M[0].length;
        
        int[][] res = new int[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++ col) {
                int cnt = 0, sum = 0;
                for (int ra : new int[]{-1, 0, 1}) {
                    for (int ca: new int[]{-1, 0, 1}) {
                        if (isValid(row + ra, col + ca, rows, cols)) {
                            ++cnt;
                            sum += M[row + ra][col + ca];
                        }
                    }
                }
                res[row][col] = sum / cnt;
            }
        }
        return res;
    }
    public boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}