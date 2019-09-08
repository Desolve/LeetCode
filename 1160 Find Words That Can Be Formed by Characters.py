from collections import Counter
class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        res = 0
        dic = Counter(chars)
        
        for word in words:
            res += self.check(word, dic)
            
        return res
    
    def check(self, word: str, dic: Counter) -> int:
        wdic = Counter(word)
        for key in wdic:
            if not key in dic or wdic[key] > dic[key]:
                return 0

        return len(word)

''' 100
class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        ret = 0

        for word in words:
            boolean = True
            for i in word:
                if word.count(i) > chars.count(i):
                    boolean = False
                    break
            if boolean:
                ret += len(word)

        return ret
'''