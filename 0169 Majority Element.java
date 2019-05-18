class Solution {
    public int majorityElement(int[] nums) {
        // Moore's voting algorithm
        int candidate = nums[0], count = 1, i = 1;
        while (i < nums.length)
        {
            if (candidate == nums[i])
            {
                count++;
            }
            else if (count == 0) 
            {
                candidate = nums[i];
            }else{
                count--;
            }
            i++;
        }
        return candidate;
    }
}