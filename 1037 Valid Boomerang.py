class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        a, b, c = points
        if a == b or b == c or c == a: return False
        return not (b[1] - a[1]) * (c[0] - a[0]) == (c[1] - a[1]) * (b[0] - a[0])
        