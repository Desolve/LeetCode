class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        dic = {}
        for k in A[0]:
            dic[k] = 1 if k not in dic else dic[k]+1
        for i in range(1, len(A)):
            for k, v in dic.items():
                dic[k] = min(dic[k], A[i].count(k))
        res = []
        for key, value in dic.items():
            for _ in range(value):
                res.append(key)
        return res

''' Use reduce and collections.Counter
import functools
import collections
class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        dic = functools.reduce(lambda x, y: collections.Counter(x) & collections.Counter(y), A)
        return list(dic.elements())
'''