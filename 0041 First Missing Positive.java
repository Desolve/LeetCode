// The key point is to place every num at the (num - 1) position
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/* if using extra O(n) space
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] res = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                res[nums[i] - 1] = true;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (!res[i]) return i + 1;
        }
        return nums.length + 1;
    }
}*/