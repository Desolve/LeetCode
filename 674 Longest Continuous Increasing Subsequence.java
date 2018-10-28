class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int len = 1, max = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                ++len;
            } else {                
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max;
    }
}