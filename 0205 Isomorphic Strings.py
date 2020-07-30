class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        dic = {}
        for i in range(len(s)):
            if s[i] not in dic:
                if t[i] in dic.values():
                    return False
                dic[s[i]] = t[i]
            elif dic[s[i]] != t[i]:
                return False
        return True
''' Use two dictionaries
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        ds, dt = {}, {}
        for i in range(len(s)):
            if s[i] not in ds and t[i] not in dt:
                ds[s[i]] = t[i]
                dt[t[i]] = s[i]
            elif ds.get(s[i], 0) != t[i] or dt.get(t[i], 0) != s[i]:
                return False
        return True
'''

''' Faster solution from caikehe
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(zip(s, t))) == len(set(s)) == len(set(t))
'''

''' Beat 100% Solution
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_table = self.RemoveDuplicate(s);
        t_table = self.RemoveDuplicate(t);
        if len(s_table) == len(t_table):
            transtab = str.maketrans(s_table, t_table);
            return s.translate(transtab) == t
        else:
            return False

    def RemoveDuplicate(self, s):
        s_set = set(s);
        result = list(s_set);
        result.sort(key=s.index);
        result = ''.join(result);
        return result
'''