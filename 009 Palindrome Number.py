class Solution:
    def isPalindrome(self, x: 'int') -> 'bool':
        if x < 0:
            return False
        strNum = str(x)
        i, j = 0, len(strNum) - 1
        while i < j:
            if strNum[i] != strNum[j]:
                return False
            i += 1
            j -= 1
        return True
'''
# Faster since compared by int, not string
class Solution:
    def isPalindrome(self, x: 'int') -> 'bool':
        return x == int(str(x)[::-1]) if x >= 0 else False
'''