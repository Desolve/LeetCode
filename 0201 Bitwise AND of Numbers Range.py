class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        factor = 0
        while n != m:
            m >>= 1
            n >>= 1
            factor += 1
        return m << factor

''' other solutions
class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        factor = 1
        while n != m:
            m >>= 1
            n >>= 1
            factor <<= 1
        return m * factor
        
class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        while n > m:
            n &= n - 1
        return n        

'''