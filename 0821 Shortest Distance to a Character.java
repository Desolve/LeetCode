class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            res[i] = 10001;
        }
        for (int i = 0; i < chs.length; ++i) {
            if (chs[i] == C) {
                for (int j = i, cnt = 0; j >= 0; j--, cnt++) {
                    if (cnt < res[j]) 
                        res[j] = cnt;
                    else
                        break;
                }
                for (int j = i+1, cnt = 1; j < chs.length; j++, cnt++) {
                    res[j] = cnt;
                }
            }
        }
        return res;
    }
}