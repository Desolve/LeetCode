class Solution:
    def findsol(self, n, diag1, diag2, used, row):
        if row == n:
            return 1
        res = 0
        for col in range(n):
            if row+col in diag1 or row-col in diag2 or col in used:
                continue
            diag1.add(row+col)
            diag2.add(row-col)
            used.add(col)
            res += self.findsol(n, diag1, diag2, used, row+1)
            diag1.remove(row+col)
            diag2.remove(row-col)
            used.remove(col)           
        
        return res
        
    def totalNQueens(self, n: int) -> int:
        diag1 = set()
        diag2 = set()
        used = set()
        return self.findsol(n, diag1, diag2, used, 0)

''' Use memory to check instead of set
class Solution:
    def findsol(self, board, n, r):
        res = 0
        if r == n:
            return 1
        else:
            for i in range(n):
                valid = True
                for j in range(r):
                    if board[j] == i or abs(board[j] - i) == abs(j - r):
                        valid = False
                        break
                if valid:
                    board[r] = i
                    res += self.findsol(board, n, r+1)
        return res
        
    def totalNQueens(self, n: int) -> int:
        board = [0 for _ in range(n)]        
        return self.findsol(board, n, 0)
'''