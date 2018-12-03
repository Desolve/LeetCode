class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        int inc = 0;
        for (int i = 1; i < A.length; ++i) {
            if (inc == 0) {
                if (A[i] > A[i - 1]) inc = 1;
                else if (A[i] < A[i - 1]) inc = -1;
            } else if (inc == 1) {
                if (A[i] < A[i - 1]) return false;
            } else {
                if (A[i] > A[i - 1]) return false;
            }
        }
        return true;
    }
}

/* Faster solution from pranavmdixit
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length <= 1){
            return true;
        }
        boolean inc = true;
        boolean dec = true;
        int prev = A[0];
        for(int i =1; i<A.length && (inc || dec); i++){
            if(A[i] > prev){
                dec = false;
            }
            if(A[i] < prev){
                inc = false;
            }
            prev = A[i];
        }
        
        return inc || dec;
    }
}
*/