class Solution:
    def removeDuplicates(self, S: str) -> str:
        res = []
        for c in S:
            if res and res[-1] == c:
                res.pop()
            else:
                res.append(c)
        return "".join(res)

'''
# Faster than 100% but brute force
class Solution:
    def removeDuplicates(self, S: str) -> str:
        dup_lst = ['aa','bb','cc','dd','ee','ff','gg','hh','ii','jj','kk','ll','mm','nn','oo','pp','qq','rr','ss','tt','uu','vv','ww','xx','yy','zz']
        if len(S) == 1:
            return S
        l_prev = len(S)
        while True:
            for dup in dup_lst:
                S = S.replace(dup,'')
            if l_prev == len(S):
                break
            else:
                l_prev = len(S)
        return S
'''
