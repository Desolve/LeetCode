// See https://leetcode.com/problems/single-number-iii/discuss/68938/JAVA-Bit-Manipulation-combining-everyone's-explanation-into-one for the idea.
class Solution {
    public int[] singleNumber(int[] nums) {
        int b = 0;
        int[] res = new int[]{0, 0};
        for (int num : nums) {
            b = b ^ num;
        }
        b &= -b;
        for (int num : nums) {
            res[(b & num) == 0? 0 : 1] ^= num; 
        }
        return res;
    }
}