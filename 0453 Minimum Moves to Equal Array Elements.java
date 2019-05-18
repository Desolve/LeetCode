// 設最終做了m次，最後所有數字都變為x，起初總和為sum
// 可知 sum + m * (n - 1) = x * n
// 對最小的數min來說，每一次一定都會加到，所以x=min+m
// 代入可得sum + m * (n - 1) = (min + m) * n => sum - min * n = m
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0, min = nums[0];
        for (int num: nums) {
            sum += num;
            if (num < min) min = num;
        }
        return sum - min * n;
    }
}