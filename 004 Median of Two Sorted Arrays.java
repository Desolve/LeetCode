// 27 ms linear solution (at 2018/12/04)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return getMedian(nums2);
        if (nums2.length == 0) return getMedian(nums1);
        int cnt = nums1.length + nums2.length;
        int m = cnt / 2;
        double res = 0.0;
        
        int prev = 0, prev2 = 0;
        int i, j, c;
        for (i = 0, j = 0, c = 0; c <= m-2; ++c) {
            if (i == nums1.length) {j += m-1-c; break;}
            else if (j == nums2.length) {i += m-1-c; break;}
            else if (nums1[i] <= nums2[j]) i++;
            else j++;
        }
        if (i == nums1.length) prev2 = nums2[j++];
        else if (j == nums2.length) prev2 = nums1[i++];
        else if (nums1[i] <= nums2[j]) prev2 = nums1[i++];
        else prev2 = nums2[j++];
        
        if (i == nums1.length) prev = nums2[j++];
        else if (j == nums2.length) prev = nums1[i++];
        else if (nums1[i] <= nums2[j]) prev = nums1[i++];
        else prev = nums2[j++];        
        
        if (cnt % 2 == 1) 
            return prev;
        else
            return (double) (prev + prev2) / 2.0;
    }
    public double getMedian(int[] num) {
        int len = num.length;
        if (len == 1) return (double) num[0];
        if (num.length % 2 == 0) {
            return (double)(num[len/2] + num[len/2 - 1]) / 2.0;
        } else {
            return (double)(num[len/2]);
        }
    }
}

/* Faster using Binary Search by Cheng_Zhang

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];            
        if (bStart > B.length - 1) return A[aStart + k - 1];                
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        

        if (aMid < bMid) 
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
        else 
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
}
*/