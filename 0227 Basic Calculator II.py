# Adapted from sfdye
class Solution:
    def calculate(self, s: str) -> int:
        if not s: return 0
        res, pre, num, ops = 0, 0, 0, '+'
        s += '$' # last sign
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c != ' ':
                if ops == '+':
                    res += pre
                    pre = num
                elif ops == '-':
                    res += pre
                    pre = -num
                elif ops == '*':
                    pre *= num
                else:
                    pre = int(pre / num)
                num = 0
                ops = c
        return res + pre