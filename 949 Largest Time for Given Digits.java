class Solution {
    public String largestTimeFromDigits(int[] A) {
        String res = dfs(A, 0, "", "");
        if (res.length() > 0) return res.substring(0, 2) + ":" + res.substring(2);
        return res;
    }
    
    public String dfs(int[] A, int from, String cur, String tmax) {
        if (from == A.length) { // End condition, check if valid then return.
            int h = Integer.valueOf(cur.substring(0, 2));
            int m = Integer.valueOf(cur.substring(2));
            if (h >= 24 || m >= 60 || cur.compareTo(tmax) < 0) return tmax;
            return cur;
        }
        
        for (int i = from; i < A.length; ++i) {
            swap(A, from, i);
            String sres = dfs(A, from + 1, cur + A[from], tmax);    // Use the i's element as the first and trace down to the 2nd, 3rd, 4th digit.
            if (sres.compareTo(tmax) > 0) tmax = sres;
            swap(A, from, i);   // swap back
        }
        return tmax;
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}