class Solution {
    public int maxSubArray(int[] nums) {      
        // O(n) solution: Dynamic Programming
        int[] imax = new int[nums.length]; // the maximum subarray sum from 0 to index i
        int res = imax[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            imax[i] = Math.max(imax[i-1] + nums[i], nums[i]);
            if (res < imax[i])
                res = imax[i];
        }
        return res; 
    }
}