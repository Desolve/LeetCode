// Adapted from lycjava3
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* 
            num	2		3		4		5
            res 3*4*5	2*4*5	2*3*5	2*3*4
            l			2		2*3		2*3*4
            r	3*4*5	4*5		5		
        */
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            res[i] = res[i-1] * nums[i-1];
        }
        
        int r = 1;
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= r;
            r *= nums[i];
        }
        
        return res;
    }
}
