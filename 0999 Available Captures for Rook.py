class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        r, c = 0, 0
        found = False
        while r < 8 and not found:
            c = 0
            while c < 8 and not found:
                if board[r][c] == 'R':
                    found = True
                else:
                    c += 1
            if not found:
                r += 1
                
        cnt = 0
        i = r + 1
        while i < 8:
            if board[i][c] == 'B': break
            elif board[i][c] == 'p':
                cnt += 1
                break
            i += 1
        i = r - 1
        while i >= 0:
            if board[i][c] == 'B': break
            elif board[i][c] == 'p':
                cnt += 1
                break
            i -= 1
        j = c + 1
        while j < 8:
            if board[r][j] == 'B': break
            elif board[r][j] == 'p':
                cnt += 1
                break
            j += 1
        j = c - 1
        while j >= 0:
            if board[r][j] == 'B': break
            elif board[r][j] == 'p':
                cnt += 1
                break
            j -= 1
        return cnt