class Solution {
    public int countBinarySubstrings(String s) {
    if (s == null || s.length() == 0) return 0;
        int pre = 0, cur = 1, cnt = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) ++cur;
            else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) ++cnt;
        }
        return cnt;
    }
}