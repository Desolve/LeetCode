class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0: return False
        m, n = len(matrix), len(matrix[0])
        lo, up = 0, m * n - 1
        while lo <= up:
            mid = (lo + up) // 2
            i, j = mid // n, mid % n
            if target == matrix[i][j]: return True
            elif target > matrix[i][j]: lo = mid + 1
            else: up = mid - 1
        
        return False