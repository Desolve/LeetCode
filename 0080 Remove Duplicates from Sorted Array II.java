class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int last = nums[0];
        int cnt = 1;
        int j = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != last) {
                nums[j++] = nums[i];
                last = nums[i];
                cnt = 1;
            } else if (cnt < 2) {
                nums[j++] = nums[i];
                ++cnt;
            }
        }
        return j;
    }
}

/* Solution from StefanPochmann
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
}
*/