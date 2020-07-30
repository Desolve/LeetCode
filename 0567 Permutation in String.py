class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if not s1 or not s2 or len(s1) > len(s2): return False
        s1h = {}
        for c in 'abcdefghijklmnopqrstuvwxyz':
            s1h[c] = 0
        for c in s1:
            s1h[c] += 1
        cnt, l, r = len(s1), 0, 0
        while r < len(s2):
            if s1h[s2[r]] > 0: cnt -= 1
            s1h[s2[r]] -= 1
            r += 1
            if cnt == 0: return True
            if r - l == len(s1):
                if s1h[s2[l]] >= 0: cnt += 1
                s1h[s2[l]] += 1
                l += 1
        return False