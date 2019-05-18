class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int m = nums[0], last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) 
                last++;
            else {
                m = Math.max(m, last);
                last = 0;
            }
        }
        return Math.max(m, last);
    }
}