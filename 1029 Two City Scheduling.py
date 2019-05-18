class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        costs.sort(key = lambda x: x[0] - x[1])
        return sum(a[0] for a in costs[:len(costs)//2]) + sum(b[1] for b in costs[len(costs)//2:])

'''
# One-line solution
class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        return sum([v[i // (len(costs)//2)] for i, v in enumerate(sorted(costs, key=lambda x: x[0] - x[1]))])

class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        alt = sorted([(a-b, a, b) for a,b in costs])
        return sum(it[1] for it in alt[:len(costs)//2]) + sum(it[2] for it in alt[len(costs)//2:])  
'''