class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        dic = {}
        l = len(pattern)
        sp = str.strip(" ").split(" ")
        if l != len(sp): return False
        
        for i in range(l):
            if pattern[i] not in dic:
                if sp[i] in dic.values():
                    return False
                dic[pattern[i]] = sp[i]
            else:
                if dic[pattern[i]] != sp[i]:
                    return False
        return True