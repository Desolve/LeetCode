class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        s, g = [0]*10, [0]*10
        l = len(secret)
        a, b = 0, 0
        
        for i in range(l):
            n1, n2 = int(secret[i]), int(guess[i])
            if n1 == n2:
                a += 1
            else:
                s[n1] += 1
                g[n2] += 1
                
        for i in range(10):
            b += min(s[i], g[i])
        
        return str(a) + "A" + str(b) + "B"
''' Solution from leetcode
from collections import Counter
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        s = Counter(secret)
        g = Counter(guess)
        secretList = list(secret)
        guessList = list(guess)
        bull, cow = 0,0
        for i, val  in enumerate(guessList):
            if secretList[i] == val: bull+=1
        cow = sum((s & g).values()) - bull
        return str(bull)+'A'+str(cow)+'B'
'''