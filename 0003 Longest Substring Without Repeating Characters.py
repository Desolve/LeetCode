class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i = res = 0
        dic = {}
        
        for j in range(len(s)):
            if s[j] in dic and i <= dic[s[j]]:
                i = dic[s[j]] + 1
            else:
                res = max(res, j - i + 1)
            dic[s[j]] = j
            
        return res