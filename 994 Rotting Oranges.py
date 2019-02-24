class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rotted, fresh = True, False
        time = 0
        m, n = len(grid), len(grid[0])
        while rotted:
            rotted, fresh = False, False
            rotting = [[False] * n for _ in range(m)]
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1:
                        if (i-1 >= 0 and grid[i-1][j] == 2 and not rotting[i-1][j]) or (i+1 < m  and grid[i+1][j] == 2 and not rotting[i+1][j]) or      (j-1 >= 0 and grid[i][j-1] == 2 and not rotting[i][j-1]) or (j+1 < n  and grid[i][j+1] == 2 and not rotting[i][j+1]):
                            grid[i][j] = 2
                            rotting[i][j] = True
                            rotted = True
                        else:
                            fresh = True
                    elif grid[i][j] == 2 and not rotting[i][j]:
                        if i-1 >= 0 and grid[i-1][j] == 1:
                            grid[i-1][j] = 2
                            rotting[i-1][j] = True
                            rotted = True
                        if i+1 < m  and grid[i+1][j] == 1:
                            grid[i+1][j] = 2
                            rotting[i+1][j] = True
                            rotted = True
                        if j-1 >= 0 and grid[i][j-1] == 1:
                            grid[i][j-1] = 2
                            rotting[i][j-1] = True
                            rotted = True
                        if j+1 < n  and grid[i][j+1] == 1:
                            grid[i][j+1] = 2
                            rotting[i][j+1] = True
                            rotted = True
            if rotted: 
                time += 1
        if fresh: 
            return -1
        return time

'''
# Solution from 2017111303
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        n,m = len(grid), len(grid[0])
        Q = collections.deque([])
        cnt = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1: cnt += 1
                if grid[i][j] == 2: Q.append((i,j))
        res = 0
        while Q:
            for _ in range(len(Q)):
                i,j = Q.popleft()
                for x, y in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
                    if 0<=x<n and 0<=y<m and grid[x][y] == 1:
                        grid[x][y] = 2
                        cnt -= 1
                        Q.append((x,y))
            res += 1
        return max(0, res-1) if cnt == 0 else -1
'''