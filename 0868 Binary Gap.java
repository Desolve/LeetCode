class Solution {
    public int binaryGap(int N) {
        int res = 0;
        while (N > 0 && (N % 2) == 0) N >>= 1;
        if (N == 0) return 0;
        int cnt = 1;
        while ((N >>= 1) > 0) {
            if ((N % 2) == 0) cnt++;
            else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }
        return res;
    }
}