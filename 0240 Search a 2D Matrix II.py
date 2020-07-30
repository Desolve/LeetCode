class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0: return False
        m, n = len(matrix), len(matrix[0])
        i, j = 0, n - 1
        
        while i < m and j >= 0:
            if target == matrix[i][j]: return True
            elif target > matrix[i][j]: i += 1
            else: j -= 1
        
        return False