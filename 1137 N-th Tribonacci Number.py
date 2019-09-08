class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0: return 0
        elif n == 1: return 1        
        n0, n1, n2 = 0, 1, 1
        for i in range(3, n + 1):
            n0, n1, n2 = n1, n2, n0 + n1 + n2
        
        return n2