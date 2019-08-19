# Solution from whissely
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        stack = []
        for i in range(len(intervals) - 1, -1, -1):
            stack.append(intervals[i])
            
        res = []
        while stack:
            cur_interval = stack.pop()
            # Left ouf of bounds
            if cur_interval[0] > newInterval[1]:
                res.append(newInterval)
                # Update newInterval to be cur_interval to ensure we always come into this condition because there is no more merging that will happen after newInterval has been appended so we keep appending the previous interval
                newInterval = cur_interval
            # Right out of bounds
            elif cur_interval[1] < newInterval[0]:
                res.append(cur_interval)
            else:
                newInterval = [min(cur_interval[0], newInterval[0]), max(cur_interval[1], newInterval[1])]
        # Append the last interval which will be the fully merged newInterval or the last cur_interval from the last iteration
        res.append(newInterval)
        return res

# Adapeted from Lenaxiao
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        s, e = newInterval[0], newInterval[1]
        add = False
        for itv in intervals:
            if not add:
                if itv[0] <= e and itv[1] >= s:
                    s = min(itv[0], s)
                    e = max(itv[1], e)
                elif itv[1] < s:
                    res.append(itv)
                else:
                    res.append([s, e])
                    res.append(itv)
                    add = True
            else:
                res.append(itv)
        if not add:
            res.append([s, e])
        
        return res
