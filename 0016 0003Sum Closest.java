class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int mindist = Math.abs(res - target);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                int dist = Math.abs(curr - target);
                if (dist == 0) return target;
                if (dist < mindist) {
                    res = nums[i] + nums[j] + nums[k];
                    mindist = dist;
                }
                if (curr < target) ++j;
                else --k;
            }
        }
        return res;        
    }
}