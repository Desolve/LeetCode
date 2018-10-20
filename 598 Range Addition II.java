class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int len = ops.length;
        if (len == 0) return m * n;
        int x = ops[0][0];
        int y = ops[0][1];
        for (int i = 1; i < len; ++i) {
            x = Math.min(x, ops[i][0]);
            y = Math.min(y, ops[i][1]);
        }        
        return x * y;
    }
}