// See https://leetcode.com/problems/single-number-ii/discuss/167343/topic for explaination from bron
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = b ^ num & ~a;
            a = a ^ num & ~b;
        }
        return b; // If you want to check appear once or twice, use a|b; If you want to check appear twice, use a.
    }
}