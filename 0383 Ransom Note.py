class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if len(ransomNote) > len(magazine):
            return False
        
        dic = {}
        for ch in magazine:
            if ch in dic:
                dic[ch] += 1
            else:
                dic[ch] = 1
        for ch in ransomNote:
            if ch not in dic or dic[ch] == 0:
                return False
            else:
                dic[ch] -= 1
        
        return True


''' solutions from leetcode
from collections import Counter
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        counter = Counter(magazine)
        for letter in ransomNote:
            if counter[letter] > 0:
                counter[letter] -= 1
            else:
                return False
        return True

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if len(ransomNote) == 0 and len(magazine) == 0:
            return True
        elif len(ransomNote) != 0 and len(magazine) == 0:
            return False
        elif len(ransomNote) == 0 and len(magazine) != 0:
            return True
        
        dict1 = {}
        for key in ransomNote:
            if key not in dict1:
                dict1[key] = 1
            else:
                dict1[key] += 1
        
        for key in dict1:
            if dict1[key] > magazine.count(key):
                return False
        return True
'''