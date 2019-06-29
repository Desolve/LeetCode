class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones.sort()
        while len(stones) > 1:
            y = stones.pop()
            x = stones.pop()
            if x != y:
                bisect.insort(stones, y - x)
        if len(stones) == 0:
            return 0
        else:
            return stones[0]