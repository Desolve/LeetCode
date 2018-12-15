// Beat 100% but a little bit dirty
class Solution {
    public int[] searchRange(int[] nums, int target) {        
        if (nums.length == 1 && nums[0] == target) return new int[]{0, 0};
        int[] res = new int[]{-1, -1};
        int lo = 0, up = nums.length - 1, mid = 0;
        boolean found = false;
        while (lo <= up) {
            mid = lo + (up - lo) / 2;
            if (nums[mid] == target) {
                found = true; break;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                up = mid - 1;
            }
        }
        if (found) {
            res[0] = findHead(nums, mid, target);
            res[1] = findTail(nums, mid, target);
        }
        return res;
    }
    public int findHead(int[] nums, int mid, int target) {
        if (mid - 1 >= 0 && nums[mid - 1] < target) return mid;
        int lo = 0, up = mid, m = mid;        
        while (lo < up) {
            m = lo + (up - lo) / 2;
            if (nums[m] < target) {
                if (m + 1 < nums.length && nums[m + 1] == target) return m + 1;
                lo = m + 1;
            } else {
                if (m - 1 >= 0 && nums[m - 1] < target) return m;
                up = m - 1;
            }
        }
        return lo;
    }
    public int findTail(int[] nums, int mid, int target) {        
        if (mid + 1 < nums.length - 1 && target < nums[mid + 1]) return mid;
        int lo = mid, up = nums.length - 1, m = mid;
        while (lo < up) {
            m = lo + (up - lo) / 2;
            if (nums[m] > target) {
                if (m - 1 >= 0 && nums[m - 1] == target) return m - 1;
                up = m - 1;
            } else {
                if (m + 1 < nums.length && nums[m + 1] > target) return m;
                lo = m + 1;
            }
        }
        return up;
    }
}