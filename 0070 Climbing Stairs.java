class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] res = new int[n];
        res[1-1] = 1;
        res[2-1] = 2;
        for(int i = 3; i <= n; i++) {
            res[i-1] = res[i-1-1] + res[i-2-1];
        }
        return res[n-1];
    }
}