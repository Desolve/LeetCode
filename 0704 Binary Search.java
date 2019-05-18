class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, up = nums.length - 1, mid;
        while (lo <= up) {
            mid = (lo + up) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                up = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}

/* Fastest solution
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        return binarySearch(nums, 0, nums.length, target);
    }
    
    int binarySearch(int[] nums, int inclusiveStart, int exclusiveEnd, int target) {
        int s = inclusiveStart, e = exclusiveEnd - 1;
        
        while(s <= e) {
            int mid = (s + e)/2;
            if(nums[mid] == target) return mid;
            else {
                if(nums[mid] > target) {
                    e = mid - 1;
                }
                else {
                    s = mid + 1;
                }
            }
        }   
        return -1;
        
    }
}
*/