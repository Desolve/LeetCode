class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length != 0) {
            int lsum = nums[0], rsum = 0;
            for (int i = 0; i < nums.length; ++i) rsum += nums[i];
            if (lsum == rsum) return 0;
            for (int i = 1; i < nums.length; ++i) {
                lsum += nums[i];
                rsum -= nums[i-1];
                if (lsum == rsum) return i;
            }
        }
        return -1;
    }
}