class Solution:
    def maximum69Number (self, num: int) -> int:
        return int(str(num).replace('6', '9', 1))
'''
class Solution:
    def maximum69Number (self, num: int) -> int:
        max_val = num
        length = len(str(num))
        for i in range(length):
            temp = list(str(num))
            temp[i] = '9'
            max_val = max(max_val, int(''.join(temp)))
        return max_val

class Solution:
    def maximum69Number (self, num: int) -> int:
        i, n, i6 = 1, num, -1
        while n > 0:
            if n % 10 == 6:
                i6 = i
            n //= 10
            i *= 10
        
        return num if i6 == -1 else num + 3 * i6
'''