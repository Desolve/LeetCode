class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return collections.Counter(s) == collections.Counter(t)

''' Faster solution
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return all(s.count(c) == t.count(c) for c in 'abcdefghijklmnopqrstuvwxyz')
'''