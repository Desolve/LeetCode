class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if len(s) > len(t): return False
        pre = 0
        for i in range(len(s)):
            try:
                pre = t.index(s[i], pre)
            except:
                return False
            pre += 1
        return True