class Solution {
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int l = secret.length();
        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < l; ++i) {
            int n1 = secret.charAt(i) - '0', n2 = guess.charAt(i) - '0';
            if (n1 == n2) {
                ++cntA;
            } else {
                ++s[n1];
                ++g[n2];
            }
        }
        for (int i = 0; i < 10; ++i) {
            if (s[i] <= g[i]) {
                cntB += s[i];
            } else {
                cntB += g[i];
            }                
        }
        return cntA + "A" + cntB + "B";
    }
}