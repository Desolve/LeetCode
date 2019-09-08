class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]: return 0
        visited = [[False] * len(grid[0]) for _ in range(len(grid))]
        res = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1' and not visited[i][j]:
                    res += 1
                    self.dfs(grid, visited, i, j)
        return res
    
    def dfs(self, grid: List[List[str]], visited: List[List[bool]], i: int, j: int) -> None:
        if i >= 0 and j >= 0 and i < len(grid) and j < len(grid[0]) and not visited[i][j] and grid[i][j] == '1':
            visited[i][j] = True
            self.dfs(grid, visited, i + 1, j)
            self.dfs(grid, visited, i - 1, j)
            self.dfs(grid, visited, i, j + 1)
            self.dfs(grid, visited, i, j - 1)