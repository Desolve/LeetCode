class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, nums, 0, nums.length - 1);
        return res;
    }
    public void recursion(List<List<Integer>> res, int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> per = new ArrayList<>();
            for (int num : nums) {
                per.add(num);
            }
            res.add(per);
        } else {
            for (int i = start; i <= end; ++i) {
                swap(nums, start, i);
                recursion(res, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}