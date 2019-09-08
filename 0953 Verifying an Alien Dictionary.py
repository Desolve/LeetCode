class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        l = len(words)
        if l < 1: return True
        pos = [0] * 26
        for i in range(26):
            pos[ord(order[i]) - 97] = i
        
        for i in range(1, l):
            if not self.check(words[i-1], words[i], pos):
                return False        
        return True
    
    def check(self, prev: str, now: str, pos: List[int]):
        slen = min(len(prev), len(now))
        for i in range(slen):
            if pos[ord(prev[i]) - 97] > pos[ord(now[i]) - 97]: return False
            elif pos[ord(prev[i]) - 97] < pos[ord(now[i]) - 97]: return True
        if len(prev) <= len(now): return True
        else: return False