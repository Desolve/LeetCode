class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l, r = 0, len(s)-1
        while l < r:
            if not s[l].isalnum():
                l += 1
                continue
            if not s[r].isalnum():
                r -= 1
                continue
            if s[l].lower() != s[r].lower():
                return False
            l += 1
            r -= 1
        return True

''' Faster Solution(60ms)
class Solution:
    def isPalindrome(self, s):
        s = ''.join(filter(str.isalnum, s)).lower()
        return s == ''.join(reversed(s))
'''
''' Faster than above(56ms)
class Solution:
    def isPalindrome(self, s):
        s = ''.join(filter(str.isalnum, s)).lower()
        return s == s[::-1]
'''
'''
class Solution:
    def isPalindrome(self, s):
        s = ''.join(filter(str.isalnum, s)).lower()
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] != s[j]: return False
            i, j = i+1, j-1
        return True
'''