class Solution {
    public boolean validPalindrome(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0, j = ca.length - 1; i < j; ++i, --j)
            if (ca[i] != ca[j]) return isp(ca, i + 1, j) || isp(ca, i, j - 1);
        return true;
    }

    private boolean isp(char[] ca, int l, int r) {
        for (int i = l, j = r; i < j; ++i, --j)
            if (ca[i] != ca[j]) return false;
        return true;
    }
}