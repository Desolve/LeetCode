class Solution:
    def climbStairs(self, n: 'int') -> 'int':
        if n == 1:
            return 1
        if n == 2:
            return 2        
        s1, s2 = 1, 2
        for _ in range(n - 2):
            s1, s2 = s2, s1 + s2
        return s2