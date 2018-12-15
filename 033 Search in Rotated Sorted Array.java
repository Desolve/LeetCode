class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0, up = nums.length -1;
        int start = nums[0], end = nums[nums.length - 1];
        while (lo < up) {
            int mid = lo + (up - lo) / 2;
            if (nums[mid] > end) {
                lo = mid + 1;
            } else {
                up = mid;
            }
        }
        int pivot = lo;
        lo = 0;
        up = nums.length -1;
        
        while (lo <= up) {
            int mid = lo + (up - lo) / 2;
            int m_piv = (mid + pivot) % nums.length;
            int val = nums[m_piv];
            if (target == val) return m_piv;
            else if (target < val) up = mid - 1;
            else lo = mid + 1;            
        }
        return -1;
    }
}