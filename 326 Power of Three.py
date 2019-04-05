class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n == 1: return True
        if n < 3: return False
        while n > 2:
            if not n % 3:
                n //= 3
            else:
                return False
        return n == 1
''' Alternative solution
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        return n > 0 and 3**19 % n == 0
'''