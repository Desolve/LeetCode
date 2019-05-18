class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] rob = new int[n];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            rob[i] = Math.max(rob[i-1], rob[i-2] + nums[i]);
        }
        return rob[n-1];
    }
}

/* Reduce Space to O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int robprev, robnext;
        robprev = nums[0];
        robnext = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int tmp = robprev;
            robprev = robnext;
            robnext = Math.max(robprev, tmp + nums[i]);
        }
        return robnext;
    }
}*/