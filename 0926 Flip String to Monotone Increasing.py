class Solution:
    def minFlipsMonoIncr(self, S: str) -> int:
        f0, f1 = 0, 0
        for ch in S:
            if ch == '0':
                f1 += 1
            else:
                f1 = min(f0, f1)
                f0 += 1
        return min(f0, f1)