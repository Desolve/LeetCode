class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        backtrack(res, subset, nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
        } else {
            backtrack(res, subset, nums, i + 1);
            subset.add(nums[i]);            
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}


/* iterative solution (adapted from sample 0 ms submission)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; ++i) {
                List l = new ArrayList<Integer>(res.get(i));
                l.add(num);
                res.add(l);
            }
        }        
        return res;        
    }
}
*/

/* backtracking with permutation (adapted from issac3)
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
*/