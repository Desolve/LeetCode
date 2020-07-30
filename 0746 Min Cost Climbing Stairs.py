class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        if not cost: return 0 # 檢查例外
        i = 2
        while i < len(cost):
            cost[i] += min(cost[i-1], cost[i-2]) # 對走到i所需的cost而言取決於走到前兩格的cost中的較小值
            i += 1
        
        return min(cost[i-1], cost[i-2]) # 最終i會停留在index n(n為cost list長度)，取倒數兩格中較小值即為解