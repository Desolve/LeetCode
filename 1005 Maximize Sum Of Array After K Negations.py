class Solution:
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        A.sort()
        # First pass, setting all negatives to positives
        for i in range(len(A)):
            if A[i] >= 0: break
            else: 
                A[i] *= -1
                K -= 1
            if K == 0: return sum(A)
        
        sm = sum(A)
        if K == 0 or K % 2 == 0: return sm
        else: return sm - 2 * min(A)