class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}

/* beat 100% solution inspired from mlblount45
// From end to start, find next gap and see if it can be jumped over.
class Solution {
    public boolean canJump(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                int gap = 1;
                while (gap > nums[i]) {
                    gap++;
                    i--;
                    if (i < 0) return false;
                }
            }
        }
        return true;
    }
}
*/