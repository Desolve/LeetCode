class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int ri = 0, rj = 0;
        int max = 1;
        for (int i = 0; i < s.length() - 1; ++i) {
            for (int j = s.length() - 1; j >= i + 1; --j) {
                if (j - i + 1 <= max) break;
                if (isPalindrome(s, i, j)) {
                    max = j - i + 1;
                    ri = i;
                    rj = j;
                }
            }
        }
        return s.substring(ri, rj+1);
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) 
                return false;
            ++i;
            --j;
        }
        return true;
    }
}
/* Expand Around Center
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
*/
/* DP solution
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        int ri = 0, rj = 0, max = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp [i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > max) {
                    ri = i; 
                    rj = j + 1;
                    max = rj - ri;
                }
            }
        }
        return s.substring(ri, rj);
    }
}
*/

/* C++ solution using Manacher's Algorithm from wxyOliver
class Solution {
   public:
    char ma[2010];
    int mp[2010];
    void manacher(string s)
    {
        int l = 0;
        ma[l++] = '$', ma[l++] = '#';
        for (int i = 0; i < s.size(); i++) ma[l++] = s[i], ma[l++] = '#';
        ma[l] = 0;
        int mx = 0, id = 0;
        for (int i = 0; i < l; i++) {
            mp[i] = mx > i ? min(mp[2 * id - i], mx - i) : 1;
            while (ma[i + mp[i]] == ma[i - mp[i] >= 0 ? i - mp[i] : 0]) mp[i]++;
            if (i + mp[i] > mx) mx = i + mp[i], id = i;
        }
    }
    string longestPalindrome(string s)
    {
        string ans;
        manacher(s);
        int max_len = 0, max_pos;
        for (int i = 0; i < 2010; i++) {
            if (mp[i] > max_len) max_len = mp[i], max_pos = i;
        }
        max_len--;
        return s.substr((max_pos - max_len) / 2, max_len);
    }
};
*/