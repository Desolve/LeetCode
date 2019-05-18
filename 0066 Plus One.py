class Solution:
    def plusOne(self, digits: 'List[int]') -> 'List[int]':
        c = 1
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                c = 0
                break
        if c == 1:
            digits = [1] + digits
        return digits
''' Combine to integer then add 1
class Solution:
    def plusOne(self, digits: 'List[int]') -> 'List[int]':
        tmp = int("".join(str(i) for i in digits)) + 1
        return [int(c) for c in str(tmp)]
'''