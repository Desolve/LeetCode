class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        int cnt = 1;
        int m1 = nums[0], m2 = 0, m3 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 3) {
                if (nums[i] > m1) {
                    m3 = m2; m2 = m1; m1 = nums[i];
                } else if (nums[i] < m1 && nums[i] > m2) {
                    m3 = m2; m2 = nums[i];
                } else if (nums[i] < m2 && nums[i] > m3) {
                    m3 = nums[i];
                }
            } else if (cnt == 2) {
                if (nums[i] > m1) {
                    m3 = m2; m2 = m1; m1 = nums[i]; cnt++;
                } else if (nums[i] < m1 && nums[i] > m2) {
                    m3 = m2; m2 = nums[i]; cnt++;
                } else if (nums[i] < m2) {
                    m3 = nums[i]; cnt++;
                }
            } else {
                if (nums[i] > m1) {
                    m2 = m1; m1 = nums[i]; cnt++;
                } else if (nums[i] < m1) {
                    m2 = nums[i]; cnt++;
                }
            }
        }
        if (cnt == 3) return m3;
        return m1;
    }
}