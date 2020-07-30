''' 1. Let all '*' become '(',
   check if '(' is enough for pairing ')'
   (From left to right)

   l < 0 during the for-loop -> false, since a ')' can't be paired.
   no '(' remains after pairing -> true
   l > 0 -> Go step 2

   2. Let all '*' become ')',
   check if ')' is enough for pairing '('
   (From left to right)

   The logic goes the same as step 1.
   If we could have enough '(' for pairing from left to right
   and have enough ')' for pairing from right to left,
   we can always let remain '*' as empty string,
   since we can't have real '(' or ')' as the remain part.
   (One of the direction will meet < 0 situation)

'''
class Solution:
    def checkValidString(self, s):
        l = r = 0
        n = len(s)
        
        for i in range(n):
            l = l + 1 if s[i] == '(' or s[i] == '*' else l - 1
            if l < 0: return False
        
        if l == 0: return True
        
        for i in range(n - 1, -1, -1):
            r = r + 1 if s[i] == ')' or s[i] == '*' else r - 1
            if r < 0: return False
        
        return True


''' Solution from lee215
    def checkValidString(self, s):
        cmin = cmax = 0
        for i in s:
            cmax = cmax - 1 if i == ")" else cmax + 1
            cmin = cmin + 1 if i == '(' else max(cmin - 1, 0)
            if cmax < 0: return False
        return cmin == 0
'''