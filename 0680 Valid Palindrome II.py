class Solution:
    def validPalindrome(self, s: str) -> bool:
        def isp(s: str, l: int, r: int) -> bool:
            while l < r:
                if s[l] != s[r]: return False
                l, r = l + 1, r - 1
            return True
                
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] != s[j]: return isp(s, i + 1, j) or isp(s, i, j - 1)
            i, j = i + 1, j - 1
        return True