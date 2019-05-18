class Solution:
    def allCellsDistOrder(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        res = [(r, c) for r in range(R) for c in range(C)]
        res.sort(key = lambda n: abs(n[0] - r0) + abs(n[1] - c0))
        return res