class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }
}

/* Faster solution since the range is limited to [-10000, 10000]
class Solution {
	public int arrayPairSum(int[] nums) {
		int[] exist = new int[20001];
		for (int i = 0; i < nums.length; ++i) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; ++i) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}	
}
*/