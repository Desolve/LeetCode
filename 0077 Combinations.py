class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res, combo = [], []
        if n <= 0 or k <= 0: return res            
        self.findCombos(res, n, k, 1, combo)
        return res
        
            
    def findCombos(self, res: List[List[int]], n: int, k: int, i: int, combo: List[int]) -> None:
        if k == 0:
            res.append(combo.copy())
        elif i + k - 1 <= n:
            combo.append(i)
            self.findCombos(res, n, k - 1, i + 1, combo)
            combo.pop()
            self.findCombos(res, n, k, i + 1, combo)

''' Don't use it in the interview!
from itertools import combinations
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        return combinations(range(1, n+1), k) 
'''