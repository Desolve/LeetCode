class Solution {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        for(; i<j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public int find(int[] nums, int i, int lo, int hi) {
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if(nums[mid] > nums[i]) {
                lo = mid;
            } else {
                hi = mid;
            }
            if(hi-lo == 1) {
                if(nums[hi] > nums[i])
                    return hi;
                else
                    return lo;
            }                
        }
        return lo;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i+1] > nums[i]) {
                int j = find(nums, i, i+1, n-1);
                swap(nums, i, j);
                reverse(nums, i+1, n-1);
                return;
            }
        }
        reverse(nums, 0, n-1);
        return;
    }
}

/* Simple Solution: 
class Solution {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        for(; i<j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n-2; i >= 0; i--)
            if(nums[i+1] > nums[i])
                for(int j = n-1; j >= i+1; j--)
                    if(nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i+1, n-1);
                        return;
                    }
        reverse(nums, 0, n-1);
        return;
    }
}*/