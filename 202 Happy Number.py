class Solution:
    def isHappy(self, n: int) -> bool:
        loop = set()
        while n not in loop:
            loop.add(n)
            sqSum = 0
            while n > 0:
                remain = n % 10
                sqSum += remain ** 2
                n //= 10
            if sqSum == 1:
                return True
            n = sqSum
        return False