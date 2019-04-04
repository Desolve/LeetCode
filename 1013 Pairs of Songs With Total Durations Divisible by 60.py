class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        res = 0
        dic = {}
        for i in range(len(time)):
            val = time[i] % 60
            if val == 0 and 0 in dic:
                res += dic[0]
            elif 60 - val in dic:
                res += dic[60 - val]
            if not val in dic:
                dic[val] = 1
            else:
                dic[val] += 1
        return res

