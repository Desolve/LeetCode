class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        if not s or not p or len(s) < len(p): return res
        pHash = {}
        for c in 'abcdefghijklmnopqrstuvwxyz':
            pHash[c] = 0
        for c in p:
            pHash[c] += 1
        cnt, l, r = len(p), 0, 0
        while r < len(s):
            if pHash[s[r]] > 0: cnt -= 1
            pHash[s[r]] -= 1
            r += 1
            if cnt == 0: res.append(l)
            if r - l == len(p):
                if pHash[s[l]] >= 0: cnt += 1
                pHash[s[l]] += 1
                l += 1
        return res