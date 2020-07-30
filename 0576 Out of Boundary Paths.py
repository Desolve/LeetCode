# Adapted from lee215
class Solution:
    def findPaths(self, m: int, n: int, N: int, i: int, j: int) -> int:
        res = [[0 for b in range(n)] for a in range(m)]
        for _ in range(N):
            res = [[(a == 0 or res[a-1][b]) + (a+1 == m or res[a+1][b]) \
                   + (b == 0 or res[a][b-1]) + (b+1 == n or res[a][b+1]) \
                   for b in range(n)] for a in range(m)]
            
        return res[i][j] % (10 ** 9 + 7)

        
'''
# Will TLE
class Solution:    
    def findPaths(self, m: int, n: int, N: int, i: int, j: int) -> int:
        def dfs(i, j, N):
            res = 0
            if N != 0:
                res += 1 if i - 1 < 0 else dfs(i-1, j, N-1)
                res += 1 if i + 1 == m else dfs(i+1, j, N-1)
                res += 1 if j - 1 < 0 else dfs(i, j-1, N-1)
                res += 1 if j + 1 == n else dfs(i, j+1, N-1)
            return res
        res = dfs(i, j, N)
        return res % (10 ** 9 + 7)

# Use dictionary to prevent TLE
class Solution:    
    def findPaths(self, m: int, n: int, N: int, i: int, j: int) -> int:        
        def dfs(i, j, N, dic):
            if (i, j, N) in dic:
                return dic[(i, j, N)]
            if N != 0:
                r = 0
                r += 1 if i - 1 < 0 else dfs(i-1, j, N-1, dic)
                r += 1 if i + 1 == m else dfs(i+1, j, N-1, dic)
                r += 1 if j - 1 < 0 else dfs(i, j-1, N-1, dic)
                r += 1 if j + 1 == n else dfs(i, j+1, N-1, dic)
                dic[(i, j, N)] = r
                return r
                
            return 0

        return dfs(i, j, N, {}) % (10 ** 9 + 7)

# LeetCode solution
class Solution:
    
    def findPaths(self, m: int, n: int, N: int, i: int, j: int) -> int:
        ret = self.findPathsHelper(m, n, N, i, j, {})
        return ret
    
    def findPathsHelper(self, m: int, n: int, N: int, i: int, j: int, memo: dict) -> int:
        
        if (i,j,N) in memo:
            return memo[(i,j,N)]
        
        if i < 0 or i >= m or j < 0 or j >= n:
            return 1
        
        if i >= N and i < m - N and j >= N and j < n - N:
            return 0
        
        if i >= m/2:
            return self.findPathsHelper(m, n, N, m-i-1, j, memo)
        
        if j >= n/2:
            return self.findPathsHelper(m, n, N, i, n-j-1, memo)
        
        ret1 = self.findPathsHelper(m, n, N-1, i-1, j, memo)
        ret2 = self.findPathsHelper(m, n, N-1, i, j-1, memo)
        ret3 = self.findPathsHelper(m, n, N-1, i+1, j, memo)
        ret4 = self.findPathsHelper(m, n, N-1, i, j+1, memo)
        
        ret = (ret1+ret2+ret3+ret4)%(10**9+7)
        memo[(i, j, N)] = ret
        
        return ret
'''