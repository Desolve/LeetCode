# (-1 % 9) == 8 in python, so we treat 0 as a special case
class Solution:
    def addDigits(self, num: int) -> int:
        return 0 if num == 0 else 1 + (num - 1) % 9