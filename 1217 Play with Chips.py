class Solution:
    def minCostToMoveChips(self, chips: List[int]) -> int:
        pair = [0, 0]
        for pos in chips:
            pair[pos & 1] += 1
        
        return min(pair)