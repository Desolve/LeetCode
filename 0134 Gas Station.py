class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start, end = len(gas) - 1, 0
        s = gas[start] - cost[start]
        while start > end:
            if s >= 0:
                s += gas[end] - cost[end]
                end += 1
            else:
                start -= 1
                s += gas[start] - cost[start]
        if s >= 0:
            return start
        return -1