class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        pr = 1
        s = 0
        i = n
        while i > 0:
            re = i % 10
            pr *= re
            s += re
            i //= 10
        return pr - s