class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int e:nums) single ^= e;
        return single;
    }
}

/* python solution
# Normal for-loop
class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for num in nums:
            res ^= num
        return res
# Use reduce (in python2)(python3 needs to import functools)
class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return reduce(lambda x, y: x ^ y, nums)
*/