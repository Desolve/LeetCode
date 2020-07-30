class Solution:
    def __init__(self):
        self.slash = [[0,0],[1,1],[2,2]]
        self.bslash = [[0,2],[1,1],[2,0]]
        self.pl = ["B", "A"]
    def tictactoe(self, moves: List[List[int]]) -> str:
        grid = [[0]*3 for _ in range(3)] # A => 2, B => 1, empty => 0
        cnt = 0
        for move in moves:
            cnt += 1
            grid[move[0]][move[1]] = cnt % 2 + 1

        if self.check(grid, move, cnt):
            return self.pl[cnt % 2]
        elif cnt == 9:
            return "Draw"
        else:
            return "Pending"

    def check(self, g: List[List[int]], m: List[int], cnt: int) -> bool:
        player = cnt % 2 + 1
        r, c = m[0], m[1]
        if ((g[r][0] == g[r][1] == g[r][2]) or 
            (g[0][c] == g[1][c] == g[2][c]) or 
            (m in self.slash and g[0][0] == g[1][1] == g[2][2]) or 
            (m in self.bslash and g[0][2] == g[1][1] == g[2][0])):
            return True
        else:
            return False
        