class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int nr = nums.length;
        int nc = nums[0].length;
        if (nr * nc != r * c) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; ++i)
            res[i / c][i % c] = nums[i / nc][i % nc];
        return res;
    }
}