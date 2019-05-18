class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;					// a XOR a = 0, 0 XOR a = a, 且XOR具交換律，故將全部都XOR後留下的即為落單的數。
        for(int i = 0; i < nums.length; i++)
            res ^= i ^ nums[i];
        return res;
    }
}

/* Another solution:
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return total - sum;
    }
}
*/