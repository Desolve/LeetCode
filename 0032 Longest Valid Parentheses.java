class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        char[] chr = s.toCharArray();
        for (int i = 1; i < s.length(); ++i) {
            if (chr[i] == ')' && i - dp[i - 1] - 1 >= 0 && chr[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}