class Solution {
    public int jump(int[] nums) {
        int res = 0, curr = 0, longest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            longest = Math.max(longest, i + nums[i]);
            if (i == curr) {
                res++;
                curr = longest;
            }
        }
        return res;
    }
}

/* Slightly faster when checking if the edge already exceeds the array length.
class Solution {
    public int jump(int[] A) {
        int maxReach = A[0];
        int edge = 0;
        int minstep = 0;

        for(int i = 1; i < A.length; i++) {
            if (i > edge) {
                minstep += 1;
                edge = maxReach;
                if(edge > A.length - 1)
                    return minstep;
            }
            maxReach = Math.max(maxReach, A[i] + i);
        }

        return minstep;
    } 
}
*/