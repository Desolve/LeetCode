class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        '''
            nums	2		3		4		5
            res     3*4*5	2*4*5	2*3*5	2*3*4
            l	    		2		2*3		2*3*4
            r	    3*4*5	4*5		5		
        '''
        n = len(nums)
        res = [0] * n
        res[0] = 1
        
        # left side
        for i in range(1, n):
            res[i] = res[i-1] * nums[i-1]
        
        r = 1
        for i in range(n-1, -1, -1):
            res[i] *= r
            r *= nums[i]
        
        return res