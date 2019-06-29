class Solution:
    def gardenNoAdj(self, N: int, paths: List[List[int]]) -> List[int]:
        res = [0] * N
        adj = [[] for i in range(N)]
        for x, y in paths:
            adj[x - 1].append(y - 1)
            adj[y - 1].append(x - 1)
        for i in range(N):
            res[i] = ({1, 2, 3, 4} - {res[j] for j in adj[i]}).pop()
        return res


'''
# faster solution
class Solution:
    def gardenNoAdj(self, N: int, paths: List[List[int]]) -> List[int]:
        ret = [1 for _ in range(N)]
        dc = {}
        for p in paths:
            d1 = min(p)
            d2 = max(p)
            if d2 in dc:
                dc[d2].append(d1)
            else:
                dc[d2] = [d1, ]
            
        for k in sorted(dc.keys()):
            a = []
            for vv in dc[k]:
                a.append(ret[vv-1])
            for x in [1, 2, 3, 4]:
                if x not in a:
                    ret[k-1] = x
                    break
        
        return ret
'''