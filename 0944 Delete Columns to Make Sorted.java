class Solution {
    public int minDeletionSize(String[] A) {
        int snum = A.length;
        int slen = A[0].length();
        int del = 0;
        for (int i = 0; i < slen; ++i) {
            char last = A[0].charAt(i);
            for (int j = 0; j < snum; ++j) {
                if (A[j].charAt(i) < last) {
                    ++del;
                    break;
                } else {
                    last = A[j].charAt(i);
                }                
            }
        }
        return del;
    }
}