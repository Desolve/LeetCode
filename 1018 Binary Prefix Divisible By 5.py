class Solution(object):
    def prefixesDivBy5(self, A):
        """
        :type A: List[int]
        :rtype: List[bool]
        """
        res = []
        num = 0
        for i in A:
            num = (num * 2 + i) % 5
            res.append(num == 0)
        return res