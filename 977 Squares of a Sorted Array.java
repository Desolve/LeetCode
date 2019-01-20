class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int s = 0, e = A.length - 1, p = A.length - 1; p >= 0; --p) {
            if (Math.abs(A[s]) > Math.abs(A[e])) {
                res[p] = A[s] * A[s];
                ++s;
            } else {
                res[p] = A[e] * A[e];
                --e;
            }
        }
        return res;
    }
}
/* In-place but slower (O(N^2))
class Solution {
    public int[] sortedSquares(int[] A) {
        if (A.length == 0) return A;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] < 0) A[i] = -A[i];
            else break;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i) {
            A[i] *= A[i];
        }
        return A;
    }
}*/