class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                arr.add(i+1);
        }
        return arr;
    }
}

/* 10 ms solution:
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0 ; i != nums.length ; i++) {
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0 ; i != nums.length; i++) {
            if (nums[i] >= 0) res.add(i+1);
        }
        return res;
    }
}
*/