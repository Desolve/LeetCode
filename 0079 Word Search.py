class Solution:
    def __init__(self):
        self.wlen = 0
        self.row = 0
        self.col = 0
        
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board) == 0 or len(board[0]) == 0: return False
        self.wlen = len(word)
        self.row = len(board)
        self.col = len(board[0])
        
        for i in range(self.row):
            for j in range(self.col):
                if self.dfs(board, i, j, 0, word):
                    return True
        return False
        
    def dfs(self, board: List[List[str]], r: int, c: int, index: int, word: str) -> bool:
        if board[r][c] != word[index]: return False
        if index == self.wlen - 1: return True
        index += 1
        tmp = board[r][c]
        board[r][c] = "0"
        if r + 1 < self.row and self.dfs(board, r+1, c, index, word): return True
        if r - 1 >= 0 and self.dfs(board, r-1, c, index, word): return True
        if c + 1 < self.col and self.dfs(board, r, c+1, index, word): return True
        if c - 1 >= 0 and self.dfs(board, r, c-1, index, word): return True
        board[r][c] = tmp
        return False