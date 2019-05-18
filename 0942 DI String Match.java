class Solution {
    public int[] diStringMatch(String S) {
        int lo = 0, up = S.length();
        int[] res = new int[up + 1];
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == 'D') res[i] = up--;
            else res[i] = lo++;
        }
        res[S.length()] = lo;
        return res;
    }
}

/* Faster solution
// Calculate and shift at the last.
class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length(), left = 0, right = 0;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i)
            res[i + 1] = S.charAt(i) == 'I' ? ++right : -- left;
        for (int i = 0; i <= n; ++i)
            res[i] -= left;
        return res;
    }
}
*/