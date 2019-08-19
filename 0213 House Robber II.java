// Use prev/curr to record will reducing space complexity to O(1) (Time complexity is O(n))
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int l = nums.length;
        int res, prev, curr;
        
        // rob house 0 -> can't rob house l-1 -> result = dp[l-2]
        prev = nums[0];
        curr = nums[0];
        for (int i = 2; i < l-1; ++i) {
            int tmp = prev;
            prev = curr;
            curr = Math.max(prev, tmp + nums[i]);
        }
        res = curr;
        
        // don't rob house 0 -> result = dp[l-1]
        prev = 0;
        curr = nums[1];
        for (int i = 2; i < l; ++i) {            
            int tmp = prev;
            prev = curr;
            curr = Math.max(prev, tmp + nums[i]);
        }
        res = Math.max(res, curr);
        
        return res;
    }
}
/* Use array to record
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int l = nums.length;
        int res = 0;
        int[] dp = new int[l];
        
        // rob house 0 -> can't rob house l-1 -> result = dp[l-2]
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < l-1; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        res = dp[l-2];
        
        // don't rob house 0 -> result = dp[l-1]
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < l; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        res = Math.max(res, dp[l-1]);
        
        return res;
    }
}*/