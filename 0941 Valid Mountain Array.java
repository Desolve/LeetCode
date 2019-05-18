class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int i = 0;
        if (A[0] >= A[1]) return false;
        while (i + 1 < A.length && A[i] < A[i + 1]) i++;
        if (i + 1 == A.length || A[i] == A[i + 1]) return false;
        for (; i + 1 < A.length; ++i) {
            if (A[i] <= A[i + 1]) return false;
        }
        return true;
    }
}

/* More clear but slower
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[0] >= A[1]) return false;
        int i = 0;
        while (i + 1 < A.length && A[i] < A[i + 1]) ++i;
        if (i + 1 == A.length || A[i] == A[i + 1]) return false;
        while (i + 1 < A.length && A[i] > A[i + 1]) ++i;
        if (i + 1 == A.length) return true;
        
        return false;
    }
}
*/