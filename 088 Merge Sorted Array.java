/* Solution A: Compared to merge by the larger values and set the values from index m+n-1 of nums1*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            if(n == 0) return;
            for(int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }
        if(n == 0) {
            return;
        }        
        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        // If nums2 runs out first, 
        // we don't need to move anymore since the remaining index from k to 0 are right there.
        // If nums1 runs out first,
        // set the remaining of nums2 to nums1's index k to 0.
        while(j >= 0)
            nums1[k--] = nums2[j--];
    }
}


/* Solution B (Slower): Shift the m integers to the right by n first, then merge by smaller nums.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            if(n == 0) return;
            for(int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }
        if(n == 0) {
            return;
        }        
        
        for(int i = m-1; i >= 0; i--) {
            nums1[i+n] = nums1[i];
            nums1[i] = 0;
        }
        int i = n, j = 0, cnt = 0;
        while(i < n+m || j < n) {
            if(i < n+m && j < n) {
                if(nums1[i] <= nums2[j]) nums1[cnt++] = nums1[i++];
                else nums1[cnt++] = nums2[j++];
            } else if(i < n+m) {
                while(i < n+m) nums1[cnt++] = nums1[i++];
                break;
            } else {
                while(j < n) nums1[cnt++] = nums2[j++];
                break;
            }            
        }
    }
}
*/