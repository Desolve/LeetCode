class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1, sec = -1, res = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= max) {
                sec = max;
                max = nums[i];
                res = i;
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }
        return (sec * 2 <= max) ? res : -1;
    }
}