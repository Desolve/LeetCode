class Solution:
    def canThreePartsEqualSum(self, A: List[int]) -> bool:
        if len(A) < 3: return False
        
        total = sum(A)
        if total % 3 != 0: return False
        part = total // 3
        
        i, s = 0, 0        
        for i in range(len(A)-1):
            s += A[i]
            if s == part: break
            
        if s != part: return False
        
        j, s = 0, 0
        for j in range(len(A)-1, i, -1):
            s += A[j]
            if s == part: break
        
        return s == part

'''
# Beat 100%
class Solution:
    def canThreePartsEqualSum(self, A: List[int]) -> bool:
        total = sum(A)
        if total % 3 != 0: return False
        cnt = s = 0
        for num in A:
            s += num
            if s == part:
                cnt += 1
                if cnt == 2:
                    return True
                s = 0
        return False

'''