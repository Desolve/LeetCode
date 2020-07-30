class Solution {
    public void sortColors(int[] nums) {
        int[] n = new int[3];
        for (int num: nums) 
            ++n[num];
        for (int i = 0; i < n[0]; ++i) nums[i] = 0;
        for (int i = n[0]; i < n[0] + n[1]; ++i) nums[i] = 1;
        for (int i = n[0] + n[1]; i < n[0] + n[1] + n[2]; ++i) nums[i] = 2;        
    }
}

/* one-pass solution
class Solution {
    public void sortColors(int[] nums) {
        int i0 = 0, i2 = nums.length - 1;
        for (int i = 0; i <= i2; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, i0++);
            } else if (nums[i] == 2) {
                swap(nums, i--, i2--);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
*/