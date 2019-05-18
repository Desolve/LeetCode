class Solution {
    public int smallestRangeI(int[] A, int K) {
        int lo = A[0], up = A[0];
        for (int num : A) {
            lo = Math.min(lo, num);
            up = Math.max(up, num);
        }
        return Math.max(0, up - lo - 2 * K);
    }
}

/* Faster solution
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i< A.length; i++){
            if(A[i] < min){
                min = A[i];
            }
            if(A[i] > max){
                max = A[i];
            }
        }
        
        if (max - min > 2 * K) return max - min - 2 * K;
        else return 0;
    }
}
*/