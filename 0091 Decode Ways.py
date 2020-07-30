class Solution:
    def numDecodings(self, s: str) -> int:
        if not s: return 0
        l = len(s)
        dp = [0] * (l+1)
        dp[0], dp[1] = 1, 1 if s[0] != "0" else 0
        prev, curr = "0", s[0]
        for i in range(2, l + 1):
            prev = curr
            curr = s[i-1]
            if curr != "0":
                dp[i] += dp[i-1]
            if prev == "1" or prev == "2" and curr <= "6":
                dp[i] += dp[i-2]
        return dp[l]