class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        rk = {}
        for a in sorted(arr):
            rk.setdefault(a, len(rk) + 1)
        
        return map(rk.get, arr)