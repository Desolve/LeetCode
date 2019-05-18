class Solution:
    def isValid(self, s: 'str') -> 'bool':
        stack, dic = [], {"{":"}","[":"]","(":")"}
        for i in range(len(s)):
            c = s[i]
            if not stack:
                stack.append(c)
            elif c == dic.get(stack[-1], ""):
                stack.pop()
            else:
                stack.append(c)
        return not stack

''' Or combine together
class Solution:
    def isValid(self, s: 'str') -> 'bool':
        stack, dic = [], {"{":"}","[":"]","(":")"}
        for i in range(len(s)):
            c = s[i]
            if stack and c == dic.get(stack[-1], ""):
                stack.pop()
            else:
                stack.append(c)
        return not stack
'''

''' Solution from hliu94
class Solution:
    def isValid(self, s: 'str') -> 'bool':
        stack=[]
        for i in s:
            if i in ['(','[','{']:
                stack.append(i)
            else:
                if not stack or {')':'(',']':'[','}':'{'}[i]!=stack[-1]:
                    return False
                stack.pop()
        return not stack
'''