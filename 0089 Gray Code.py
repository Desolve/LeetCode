class Solution:
    def grayCode(self, n: int) -> List[int]:
        res = [0]
        add = 1
        for _ in range(n):
            for i in range(add):
                res.append(res[add - 1 - i] | add);
            add <<= 1
        return res
