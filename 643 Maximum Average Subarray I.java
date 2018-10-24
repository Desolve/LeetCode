class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i, j;
        long mx;
        long now = 0;
        for (int s = 0; s < k; ++s) now += nums[s];
        mx = now;
        for (i = 1, j = k; j < nums.length; ++i, ++j) {
            now = now - nums[i-1] + nums[j];
            mx = Math.max(mx, now);
        }
        return (double) mx / k;
    }
}