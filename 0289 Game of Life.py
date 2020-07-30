class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # global definitions
        m, n = len(board), len(board[0])
        d = [(i, j) for i in range(-1, 2) for j in range(-1, 2) if j != 0 or i != 0]        
        
        # functions
        def check(board, i, j):
            cnt = 0
            for k in range(8):
                cnt += alive(board, i + d[k][0], j + d[k][1])
            if board[i][j] % 2 == 1:
                if cnt == 2 or cnt == 3: board[i][j] += 2
            elif cnt == 3:
                board[i][j] += 2
                
        def alive(board, i, j):
            if i < 0 or j < 0 or i >= m or j >= n:
                return 0
            else:
                return board[i][j] % 2
        
        def next(board):
            for i in range(m):
                for j in range(n):
                    board[i][j] //= 2      
        
        # check and get next
        for i in range(m):
            for j in range(n):
                check(board, i, j)
        next(board)
