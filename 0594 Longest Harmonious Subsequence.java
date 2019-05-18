class Solution {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) return 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key: map.keySet()) {
            if (map.containsKey(key+1))
                len = Math.max(len, map.get(key+1) + map.get(key));
        }
        return len;
    }
}
/* Faster solution
class Solution {
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int nextstart = 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[start] == 1) {
                if (nums[nextstart] < nums[i]) {
                    nextstart = i;
                }
                res = Math.max(res, i - start + 1);
            } else if (nums[i] - nums[start] > 1) {
                start = start == nextstart ? i : nextstart;
                i--;
            }
        }
        return res;
    }
}
*/