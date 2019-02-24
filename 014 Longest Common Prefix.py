class Solution:
    def longestCommonPrefix(self, strs: 'List[str]') -> 'str':
        if not strs: return ""
        s1 = min(strs)
        s2 = max(strs) # In alphabetic order so it is promised that we can only compare s1 to s2
        
        for i, c in enumerate(s1):
            if c != s2[i]:
                return s1[:i]
        return s1
        