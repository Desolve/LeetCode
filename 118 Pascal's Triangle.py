class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(numRows):
            row = []
            for j in range(i+1):
                if j == 0 or j == i:
                    row.append(1)
                else:
                    p1 = res[i-1][j-1]
                    p2 = res[i-1][j]
                    row.append(p1+p2)
            res.append(row[:])
        return res
''' Allocate all first solution from girikuncoro
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]*(i+1) for i in range(numRows)]
        for i in range(numRows):
            for j in range(1, i):
                res[i][j] = res[i-1][j-1] + res[i-1][j]
        return res
'''

''' Solution from tlp108
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        for i in range(1, numRows):
            res += [list(map(lambda x, y: x+y, res[-1] + [0], [0] + res[-1]))]
        return res[:numRows]
'''