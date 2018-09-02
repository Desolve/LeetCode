class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 1)
            return len;
        int seen = nums[0];
        int next = 1;
        for (int i = 0; i < len; i++) {
            if(nums[i] == seen) {
                continue;
            } else {
                seen = nums[i];
                nums[next] = nums[i];
                next++;
            }
                
        }
        return next;
    }
}