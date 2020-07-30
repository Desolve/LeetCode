class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int[] s1h = new int[26];
        for (char c : s1.toCharArray()) ++s1h[c - 'a'];
        int l = 0, r = 0, cnt = s1.length();
        while (r < s2.length()) {
            if (s1h[s2.charAt(r++) - 'a']-- > 0) --cnt;
            if (cnt == 0) return true;
            if (r - l == s1.length() && s1h[s2.charAt(l++) - 'a']++ >= 0) ++cnt;
        }
        return false;
    }
}