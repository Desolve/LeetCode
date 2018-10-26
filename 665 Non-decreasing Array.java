class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) return true;
        int prev = nums[0], cnt = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (prev > nums[i]){
                if (cnt++ > 0) return false;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
}

/* Modifying input solution
class Solution {
    public boolean checkPossibility(int[] a) {
        int modified = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if (modified++ > 0) return false;
                if (i - 2 < 0 || a[i - 2] <= a[i]) a[i - 1] = a[i]; // lower a[i - 1]
                else a[i] = a[i - 1]; // rise a[i]
            }
        }
        return true;
    }
}
*/