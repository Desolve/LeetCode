class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length];
        int[] res = new int[2];
        for (int i : nums) {
            ++cnt[i-1];
            if (cnt[i-1] == 2) 
                res[0] = i;
        }
        for (int j = 0; j < cnt.length; ++j) {
            if (cnt[j] == 0) {
                res[1] = j + 1;
                return res;
            }
        }
        return res;
    }
}

/* Another cool solution from yanjdeng
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2]; // duplicate, missing
        //For each number we found, set nums[number-1] to its negative value (<0)
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i])-1; //since index starts from 0, and the set starts from 1
            if(nums[idx]> 0) nums[idx] = -nums[idx];
            else res[0] = idx+1; //have already been found
        }
        // At this point, only nums[missingNumber-1] > 0
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <0) nums[i] = -nums[i]; //restore the original values
            else res[1]=i+1;//since index starts from 0, and the set starts from 1
        }
        return res;
    }
}
*/