class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        while (A[i] < A[i + 1]) ++i;
        return i;
    }
}

/* binary search
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 1, up = A.length - 2;
        int mid;
        while (lo <= up) {
            mid = (lo + up) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
            else if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            } else {
                up = mid - 1;
            }
        }
        return -1;
    }
}
*/