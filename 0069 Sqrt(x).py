class Solution:
    def mySqrt(self, x: 'int') -> 'int':        
        lo, hi = 1, x        
        while hi >= lo:     
            mi = (hi + lo) // 2
            sq = mi * mi
            if sq == x:
                return mi
            elif sq > x:
                hi = mi - 1
            else:
                lo = mi + 1       
        return hi