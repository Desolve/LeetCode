// from ankit041288
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() > 1 && p.charAt(1) == '*') {
            // check with zero occurences || more than one occurance if s and p start with same char or '.'
            return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p));
        } else {
            //if s and p start with same char or '.' && s[1....n] and p[1...m] matches
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }
}

/* dp solution from serdaroquai
// Please also see https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation for detail explaination
class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);
        
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=2; j<=p.length(); ++j) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
        }
        
        for (int j=1; j<=p.length(); ++j) {
            for (int i=1; i<=s.length(); ++i) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') 
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
            }
        }
        return dp[s.length()][p.length()];
    }
}
*/