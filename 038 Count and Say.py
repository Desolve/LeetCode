class Solution:
    def countAndSay(self, n: 'int') -> 'str':
        if n == 1:
            return '1'
        s = self.countAndSay(n-1)
        cnt = 0
        res = []
        for i in range(len(s)):
            cnt += 1
            if i == len(s) - 1 or s[i] != s[i+1]:
                res.extend([str(cnt), s[i]])
                cnt = 0
        return ''.join(res)