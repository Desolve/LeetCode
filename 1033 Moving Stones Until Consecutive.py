class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        if a > b:
            a, b = b, a
        if c < a:
            a, b, c = c, a, b
        elif c < b:
            b, c = c, b
        
        res = [0, 0]
        if a == b - 1 and b == c - 1:
            return res
        if a == b - 1 or b == c - 1:
            res[0] = 1
        elif a == b - 2 or b == c - 2:
            res[0] = 1
        else:
            res[0] = 2
        
        res[1] = c - a - 2
        
        return res